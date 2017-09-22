package com.situ.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.situ.pojo.User;

public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		String uri = httpServletRequest.getRequestURI();
		String s = httpServletRequest.getServletPath();
		System.out.println(uri+"----------------");
		String requestPath = uri.substring(uri.lastIndexOf("/") + 1, uri.length());
		System.out.println(requestPath+"+++++++++++++++++++++");
		
		if ( requestPath.contains(".css") || requestPath.contains(".js")) {
			chain.doFilter(request, response);
		} else if (requestPath.equals("index.jsp")) {
			
			//定义cookie_userName  和  cookie_password
			String cookie_userName = null;
			String cookie_password = null;
			//获得cookies
			Cookie[] cookies = httpServletRequest.getCookies();
			if (cookies != null) {
				
				for (Cookie cookie : cookies) {
					if ("cookie_userName".equals(cookie.getName())) {
						//获得userName
						cookie_userName = cookie.getValue();
						//京userName转成中文
						cookie_userName = URLDecoder.decode(cookie_userName, "utf-8");
					}
					
					if ("cookie_password".equals(cookie.getName())) {
						cookie_password = cookie.getValue();
					}
				}
				
				request.setAttribute("cookie_userName", cookie_userName);
				request.setAttribute("cookie_password", cookie_password);
				chain.doFilter(request, response);
				return ;
				
			}
			
			
			chain.doFilter(request, response);
			
		} else if (requestPath.equals("loginIn.action") || requestPath.equals("checkImg.action") || requestPath.equals("user.action") || requestPath.equals("index.jpg")  ) {
			chain.doFilter(request, response);
			return ;
		}else {
			String httpServlet = httpServletRequest.getServletPath();
			//必须过滤掉注册和登录user为空的信息
			HttpSession session = httpServletRequest.getSession();
			User user = (User) session.getAttribute("user");
			if (user != null) {
				chain.doFilter(request, response);
				return ;
			} else {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/index.jsp");
			}
			
			
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
