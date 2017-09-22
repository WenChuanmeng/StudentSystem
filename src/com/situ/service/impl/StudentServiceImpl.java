package com.situ.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.dao.StudentDao;
import com.situ.pojo.Student;
import com.situ.service.IStudentService;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

@Service("studentService")
public class StudentServiceImpl implements IStudentService {

	@Resource(name="studentDao")
	private StudentDao studentDao;
	
	@Override
	public List<Student> finAll() {
		
		return studentDao.findAll();
	}

	@Override
	public PageBean<Student> pageList(Integer pageIndex, Integer pageSize) {
		
		PageBean<Student> pageBean = new PageBean<Student>();
		//设置当前页
		pageBean.setPageIndex(pageIndex);
		//设置一页有多少数据
		pageBean.setPageSize(pageSize);
		int totalSize = studentDao.totalSize();
		//看有多少页
		int totalPage = (int) Math.ceil(1.0 * totalSize / pageSize);
		pageBean.setTotalPage(totalPage);
		pageBean.setTotalSize(totalSize);
		int index = (pageIndex - 1) * pageSize;
		List<Student> list = studentDao.pageList(index,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Student> pageListByCondition(SearchByCondition<Student> condition) {
		
		PageBean<Student> pageBean = new PageBean<Student>();
		//设置当前页
		pageBean.setPageIndex(condition.getPageIndex());
		condition.setPageIndex((condition.getPageIndex() - 1) * condition.getPageSize());
		//设置一页有多少数据
		pageBean.setPageSize(condition.getPageSize());
		int totalSize = studentDao.totalSizeByCondition(condition);
		//看有多少页
		int totalPage = (int) Math.ceil(1.0 * totalSize / condition.getPageSize());
		pageBean.setTotalPage(totalPage);
		pageBean.setTotalSize(totalSize);
		List<Student> list = studentDao.pageListByCondition(condition);
		for (Student student : list) {
			System.out.println(student+"++++++++++");
		}
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void addStudent(Student student) {
		
		int result = studentDao.addStudent(student);
		if (result > 0) {
			System.out.println("学生添加成功" + result);
		} else {
			System.out.println("学生添加失败" + result);
		}
	}

	@Override
	public Student findById(int id) {
		
		return studentDao.findById(id);
	}

	@Override
	public boolean update(Student student) {
		int result = studentDao.update(student);
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delStudent(int id) {
		int result = studentDao.delStudent(id);
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deletAll(Integer[] selectIds) {
		
		int result = 0;
		
		for (int i = 0; i < selectIds.length; i++) {
			studentDao.delStudent(selectIds[i]);
			result++;
		}
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
		
	}

	
}
