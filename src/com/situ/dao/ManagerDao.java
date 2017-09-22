package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.pojo.Banji;
import com.situ.pojo.Course;
import com.situ.pojo.Student;
import com.situ.vo.SearchByCondition;

public interface ManagerDao {

	/**
	 * 根据id删除课程
	 * @param bid
	 * @param cid
	 * @return int
	 */
	int delCourse(@Param("bid")Integer bid, @Param("cid")Integer cid);

	/**
	 * 获得所有的课程
	 * @return List<Course>
	 */
	List<Course> findAllCourse();

	/**
	 * 添加课程表
	 * @param bid
	 * @param cid
	 * @return int
	 */
	int addCourse(@Param("bid")Integer bid, @Param("cid")Integer cid);

	/**
	 * 根据学号查询学生
	 * @param sno
	 * @return Student
	 */
	Student findBySno(String sno);

}
