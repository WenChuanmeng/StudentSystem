package com.situ.dao;

import com.situ.pojo.User;

public interface LoginDao {

	/**
	 * 检测用户名是否存在
	 * @param userName
	 * @return User
	 */
	User checkUserName(String userName);

	/**
	 * 查找用户
	 * @param user
	 * @return User
	 */
	User checkUser(User user);

}
