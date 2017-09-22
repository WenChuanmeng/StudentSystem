package com.situ.service;

import org.springframework.stereotype.Service;

import com.situ.pojo.User;


public interface ILoginService {

	/**
	 * 判断用户名是否存在
	 * @param userName
	 * @return boolean
	 */
	boolean checkUserName(String userName);

	/**
	 * 登录检测用户
	 * @param user1
	 * @return User
	 */
	User checkUser(User user1);

}
