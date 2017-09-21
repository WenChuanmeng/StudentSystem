package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.situ.pojo.Course;
import com.situ.vo.SearchByCondition;

public interface CourseDao {

	/**
	 * 查询有多少条数据
	 * @return int
	 */
	public int totalSize();

	/**
	 * 对查询到的课程进行分页操作
	 * @param pageIndex
	 * @param pageSize
	 * @return List<Course>
	 */
	public List<Course> pageList(@Param("pageIndex")int pageIndex, @Param("pageSize")Integer pageSize);

	/**
	 * 获得课程的班级数
	 * @return List<Course> 
	 */
	public List<Course> getTotalBanjis();

	/**
	 * 获得课程的人数
	 * @return List<Course> 
	 */
	public List<Course> getTotalPersons();

	/**
	 * 根据条件查询符合课程数
	 * @param condition
	 * @return int
	 */
	public int totalSizeByCondition(SearchByCondition<Course> condition);

	/**
	 * 根据条件查询分页
	 * @param condition
	 * @return List<Course>
	 */
	public List<Course> pageListByCondition(SearchByCondition<Course> condition);

	/**
	 * 根据添加课程
	 * @param course
	 * @return int
	 */
	public int addCourse(Course course);

	/**
	 * g根据id查找课程
	 * @param id
	 * @return Course
	 */
	public Course findById(Integer id);

	/**
	 * 更新课程
	 * @param course
	 * @return int
	 */
	public int update(Course course);

	/**
	 * 根据id删除课程
	 * @param id
	 * @return int
	 */
	public int delCourse(Integer id);

}
