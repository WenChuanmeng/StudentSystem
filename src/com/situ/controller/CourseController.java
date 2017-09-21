package com.situ.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.pojo.Course;
import com.situ.service.ICourseService;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

@Controller
@RequestMapping("course")
public class CourseController {

	@Resource(name="courseService")
	private ICourseService courseService;
	
	@RequestMapping("pageList")
	private String pageList(Integer pageIndex, Integer pageSize, Model model) {
		
		if (pageIndex == null) {
			pageIndex = 1;
		}
		
		pageSize = 5;
		//获得所选的班级数
		getTotalBanjis(model);
		//获得所选课程的额人数
		getTotalPersons(model);
		
		PageBean<Course> pageBean = courseService.pageList(pageIndex, pageSize);
		model.addAttribute("pageBean", pageBean);
		return "course_show";
	}
	
	//进行条件查询分页
	@RequestMapping("seacherByCondition")
	private String seacherByCondition(SearchByCondition<Course> condition, Model model) {
		
		if (condition.getPageIndex() == null) {
			condition.setPageIndex(1);
		}
		
		condition.setPageSize(5);
		
		//获得所选的班级数
		getTotalBanjis(model);
		//获得所选课程的额人数
		getTotalPersons(model);
		PageBean<Course> pageBean = courseService.pageListByCondition(condition);
		model.addAttribute("pageBean", pageBean);
		return "course_show";
	}
	
	//跳转到添加课程的页面
	@RequestMapping("/toAddCourse")
	private String toAddCourse(Model model) {
		
		return "course_add";
	}
	
	//添加课程
	@RequestMapping("/addCourse")
	private String addCourse(Course course) {
		
		courseService.addCourse(course);
		return "redirect:pageList.action";
	}
	
	//跳转到修改修改课程的界面
	@RequestMapping("toUpdate")
	private String toUpdate(Integer id,Model model) {
		
		Course course = courseService.findById(id);
		model.addAttribute("course", course);
		return "course_update";
	}
	
	//修改课程
	@RequestMapping("/update")
	private String update(Course course) {
		
		boolean result = courseService.update(course);
		return "redirect:pageList.action";
	}
	
	//删除课程信息
	@RequestMapping("/delCourse")
	private String delCourse(Integer id) {
		
		boolean result = courseService.delCourse(id);
		return "redirect:pageList.action";
	}
	
	///////////////////////////////////////////////////////////////////
	//获得所选的班级数
	private void getTotalBanjis(Model model) {
		
		List<Course> tbsList = courseService.getTotalBanjis();
		model.addAttribute("tbsList", tbsList);
	}
	//获得所选课程的额人数
	private void getTotalPersons(Model model) {
		List<Course> tpsList = courseService.getTotalPersons();
		model.addAttribute("tpsList", tpsList);
	}
}
