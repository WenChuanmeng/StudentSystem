package com.situ.service;

import com.situ.pojo.User;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

public interface IAdminService {

	PageBean<User> pageList(Integer pageIndex, Integer pageSize);

	PageBean<User> conditionPageList(SearchByCondition<User> condition);

	boolean addUser(User user);

	boolean delUser(int parseInt);

	User seacherById(int uid);

	boolean update(User user);

}
