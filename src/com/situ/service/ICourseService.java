package com.situ.service;

import java.util.List;

import com.situ.pojo.Course;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

public interface ICourseService {

	/**
	 * 查询班级并进行分页
	 * @param pageIndex
	 * @param pageSize
	 * @return PageBean<Course>
	 */
	public PageBean<Course> pageList(Integer pageIndex, Integer pageSize);

	/**
	 * 获得所选课程的班级数
	 * @return List<Course>
	 */
	public List<Course> getTotalBanjis();

	/**
	 * 获得课程的人数
	 * @return List<Course>
	 */
	public List<Course> getTotalPersons();

	/**
	 * 根据条件查询分页
	 * @param condition
	 * @return PageBean<Course>
	 */
	public PageBean<Course> pageListByCondition(SearchByCondition<Course> condition);

	/**
	 * 添加课程
	 * @param course
	 * @return boolean
	 */
	public boolean addCourse(Course course);

	/**
	 * 根据id查找课程
	 * @param id
	 * @return Course
	 */
	public Course findById(Integer id);

	/**
	 *   更新课程信息
	 * @param course
	 * @return boolean
	 */
	public boolean update(Course course);

	/**
	 * 删除课程
	 * @param id
	 * @return boolean
	 */
	public boolean delCourse(Integer id);
	

}
