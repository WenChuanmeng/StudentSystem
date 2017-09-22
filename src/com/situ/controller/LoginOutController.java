package com.situ.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("loginOut")
public class LoginOutController {

	@RequestMapping("/loginOut")
	private void loginOut(HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession = request.getSession(false);
		
		if (httpSession != null) {
			//移出session
			//httpSession.removeAttribute("user");
			//User user = (User) httpSession.getAttribute("users");
			httpSession.invalidate();
		}
		
		response.setContentType("text/html;charset=utf-8");
		try {
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
