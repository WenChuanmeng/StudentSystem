package com.situ.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.situ.pojo.Student;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

@Repository("studentDao")
public interface StudentDao {

	/**
	 * 查找所有学生
	 * @return List<Student>
	 */
	public List<Student> findAll();

	/**
	 * 查询一共有多少学生
	 * @return
	 */
	public int totalSize();

	/**
	 * 根据分页查询学生
	 * @param pageBean
	 * @return List<Student>
	 */
	public List<Student> pageList(@Param("index")int index, @Param("pageSize")int pageSize);

	/**
	 * 根据条件查询有多少学生
	 * @param condition
	 * @return
	 */
	public int totalSizeByCondition(SearchByCondition<Student> condition);

	/**
	 * 根据条件对学生进行分页查询
	 * @param condition
	 * @return
	 */
	public List<Student> pageListByCondition(SearchByCondition<Student> condition);

	/**
	 * 添加学生
	 * @param student
	 * @return int
	 */
	public int addStudent(Student student);

	/**
	 * 根据id查找学生
	 * @param id
	 * @return
	 */
	public Student findById(int id);

	/**
	 * 更新学生信息
	 * @param student
	 * @return int
	 */
	public int update(Student student);

	/**
	 * 根据id删除学生
	 * @param id
	 * @return int
	 */
	public int delStudent(int id);
	

	
}
