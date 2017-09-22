package com.situ.service;

import java.util.List;

import com.situ.pojo.Course;
import com.situ.pojo.Student;

public interface IManagerService {

	/**
	 * 根据班级id和课程id删除班级课程表的数据
	 * @param bid
	 * @param cid
	 * @return boolean
	 */
	public boolean delCourse(Integer bid, Integer cid);

	/**
	 * 获得所有课程
	 * @return List<Course>
	 */
	public List<Course> findAllCourse();

	/**
	 * 添加课程表
	 * @param bid
	 * @param cids
	 * @return boolean
	 */
	public boolean addCourse(Integer bid, Integer[] cids);

	/**
	 * 根据学号查询学生
	 * @param sno
	 * @return Student
	 */
	public Student findBySno(String sno);

}
