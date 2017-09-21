package com.situ.service;

import java.util.List;

import com.situ.pojo.Student;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

public interface IStudentService {

	/**
	 * 测试查找所有的学生
	 * @return List<Student>
	 */
	public List<Student> finAll();

	/**
	 * 进行分页
	 * @param pageIndex
	 * @param pageSize
	 * @return PageBean<Student>
	 */
	public PageBean<Student> pageList(Integer pageIndex, Integer pageSize);

	/**
	 * 根据条件分页
	 * @param condition
	 * @return PageBean<Student>
	 */
	public PageBean<Student> pageListByCondition(SearchByCondition<Student> condition);

	/**
	 * 添加学生
	 * @param student
	 */
	public void addStudent(Student student);

	/**
	 * 根据ID查找学生
	 * @return Student
	 */
	public Student findById(int id);

	/**
	 * 更新学生信息
	 * @param student
	 * @return 
	 */
	public boolean update(Student student);

	/**
	 * 根据id删除学生
	 * @param id
	 * @return 
	 */
	public boolean delStudent(int id);

}
