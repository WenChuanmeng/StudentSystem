package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.pojo.User;
import com.situ.vo.SearchByCondition;

public interface AdminDao {

	int totalSize();

	List<User> pageList(@Param("index")int index, @Param("pageSize")Integer pageSize);

	int totalSizeByCondition(SearchByCondition<User> condition);

	List<User> seacherByCondition(SearchByCondition<User> condition);

	int addUser(User user);

	int delUser(int uid);

	User searchById(int uid);

	int updateUSer(User user);

}
