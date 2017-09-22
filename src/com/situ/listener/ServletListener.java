package com.situ.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.situ.pojo.User;

public class ServletListener implements ServletContextListener {

    public ServletListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	
    	//新建一个userlist集合
    	List<User> onlineUserList = new ArrayList<User>();
    	//将这个结合添加到ServletContext域中
    	ServletContext servletContext = sce.getServletContext();
    	servletContext.setAttribute("onlineUserList", onlineUserList);
    	int count = 0;
    	servletContext.setAttribute("count", count);
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    }
	
}
