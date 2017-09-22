package com.situ.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.dao.LoginDao;
import com.situ.pojo.User;
import com.situ.service.ILoginService;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {

	@Resource(name="loginDao")
	private LoginDao loginDao;
	
	@Override
	public boolean checkUserName(String userName) {

		User user = loginDao.checkUserName(userName);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User checkUser(User user) {
		
		return loginDao.checkUser(user);
	}

}
