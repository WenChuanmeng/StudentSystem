package com.situ.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.dao.CourseDao;
import com.situ.pojo.Course;
import com.situ.service.ICourseService;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

@Service("courseService")
public class CourseServiceImpl implements ICourseService {

	@Resource(name="courseDao")
	private CourseDao courseDao;

	@Override
	public PageBean<Course> pageList(Integer pageIndex, Integer pageSize) {
		
		PageBean<Course> pageBean = new PageBean<Course>();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalSize = courseDao.totalSize();
		pageBean.setTotalSize(totalSize);;
		int totalPage = (int) Math.ceil(1.0 * totalSize / pageSize);
		pageBean.setTotalSize(totalSize);
		pageBean.setTotalPage(totalPage);
		List<Course> list = courseDao.pageList(((pageIndex - 1) * pageSize), pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public List<Course> getTotalBanjis() {
		
		return courseDao.getTotalBanjis();
	}

	@Override
	public List<Course> getTotalPersons() {
		
		return courseDao.getTotalPersons();
	}

	@Override
	public PageBean<Course> pageListByCondition(SearchByCondition<Course> condition) {
		PageBean<Course> pageBean = new PageBean<Course>();
		pageBean.setPageIndex(condition.getPageIndex());
		pageBean.setPageSize(condition.getPageSize());
		condition.setPageIndex((condition.getPageIndex() - 1) * condition.getPageSize());
		int totalSize = courseDao.totalSizeByCondition(condition);
		int totalPage = (int) Math.ceil(1.0 * totalSize / condition.getPageSize());
		pageBean.setTotalSize(totalSize);
		pageBean.setTotalPage(totalPage);
		List<Course> list = courseDao.pageListByCondition(condition);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public boolean addCourse(Course course) {
		
		int result = courseDao.addCourse(course);
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Course findById(Integer id) {
		
		return courseDao.findById(id);
	}

	@Override
	public boolean update(Course course) {
		
		int result = courseDao.update(course);
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delCourse(Integer id) {
		
		int result = courseDao.delCourse(id);
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
