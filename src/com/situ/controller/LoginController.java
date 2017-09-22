package com.situ.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.pojo.User;
import com.situ.service.ILoginService;

@Controller
@RequestMapping("login")
public class LoginController {

	@Resource(name="loginService")
	private ILoginService loginService;
	
	//检查用户名是否存在
	@RequestMapping("/checkUserName")
	private void checkUserName(String uname, HttpServletResponse response) {
		
		boolean isExist = loginService.checkUserName(uname);
		response.setContentType("text/html;charset=utf-8");
		try {
			response.getWriter().write("{\"isExist\":" + isExist + "}");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	//登录
	@RequestMapping("/loginIn")
	private void loginIn(User user1, HttpServletRequest request, HttpServletResponse response) {
		
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession httpSession = request.getSession();
		String checkCode = request.getParameter("checkCode");
		String checkcode_session = (String) httpSession.getAttribute("checkcode_session");
		/*//1.创建一个session对象
		if ((checkCode == null) && ("".equals(checkCode))) {
			request.setAttribute("error", "");
			try {
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return ;
		}
		
		if (!checkCode.equalsIgnoreCase(checkcode_session)) {
			request.setAttribute("error", "验证码错误");
			try {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return ;
		}*/
		
		String permission = request.getParameter("permission");
		
		if ((permission == null) && ("".equals(permission))) {
			request.setAttribute("error", "角色不能为空");
			try {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return;
		}
		
		User user = loginService.checkUser(user1);
		HttpSession session = request.getSession();
		
		if (user != null) {
			
			session.setAttribute("user", user);
			
			ServletContext servletContext = request.getServletContext();
			List<User> onlineUserList = (List<User>) servletContext.getAttribute("onlineUserList");
			onlineUserList.add(user);
			
			int count = (int) servletContext.getAttribute("count");
			count++;
			servletContext.setAttribute("count", count);
			
			//设置用户名和密码到cookie
			//检测用户是否勾选了 记住密码
			String rememberPassword = request.getParameter("rememberPassword");
			
			if (rememberPassword != null) {
				
				//对中文的userName进行编码
				
				String userName_encode = null;
				try {
					userName_encode = URLEncoder.encode(user.getUname(), "utf-8");
				} catch (UnsupportedEncodingException e) {
					
					e.printStackTrace();
				}
				Cookie cookie_userName = new Cookie("cookie_userName", userName_encode);
				Cookie cookie_password = new Cookie("cookie_password", user.getPassword());
				//设置持久化时间
				cookie_userName.setMaxAge(60*60*24);
				cookie_password.setMaxAge(60*60*24);
				//设置cookie的携带路径
				cookie_userName.setPath(request.getContextPath());
				cookie_password.setPath(request.getContextPath());
				//发送cookie
				response.addCookie(cookie_userName);
				response.addCookie(cookie_password);
				
			}
			
			
			
			if (user.getPermission() == 1 ) {
				try {
					response.sendRedirect(request.getContextPath()+"/user/pageList.action");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}else if (user.getPermission() == 2) {
				try {
					response.sendRedirect(request.getContextPath()+"/student/pageList.action");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		} else {
			request.setAttribute("error", "用户名或密码错误");
			try {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
}
