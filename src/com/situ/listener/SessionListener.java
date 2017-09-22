package com.situ.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.situ.pojo.User;

public class SessionListener implements HttpSessionListener {

    public SessionListener() {
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	
    	HttpSession httpSession = se.getSession();
    	ServletContext servletContext = httpSession.getServletContext();
    	//获得servletContext中的attribute值
    	List<User> onlineUserList = (List<User>) servletContext.getAttribute("onlineUserList");
    	//判断是否为空
    	Object user = httpSession.getAttribute("user");
    	if (user != null) {
    		onlineUserList.remove(user);
    		int count = (int) servletContext.getAttribute("count");
    		count--;
    		servletContext.setAttribute("count", count);
    		
		}
    }
	
}
