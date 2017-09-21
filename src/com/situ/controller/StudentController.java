package com.situ.controller;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.pojo.Banji;
import com.situ.pojo.Student;
import com.situ.service.IBanjiService;
import com.situ.service.IStudentService;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

@SuppressWarnings("all")
@Controller
@RequestMapping("/student")
public class StudentController {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }

	@Resource(name="studentService")
	private IStudentService studentService;
	@Resource(name="banjiService")
	private IBanjiService banjiService;
	
	//查找所有的学生
	@RequestMapping("/findAll")
	private String findAll(Model model) {
		
		List<Student> list = studentService.finAll();
		model.addAttribute("list", list);
		return "student_show";
	}
	
	//分页
	@RequestMapping("/pageList")
	private String pageList(Integer pageIndex, Integer pageSize, Model model) {
		
		if (pageIndex == null) {
			pageIndex = 1;
		}
		
		pageSize = 3;
		//获得所有的班级，条件查询
		getBanji(model);
		PageBean<Student> pageBean = studentService.pageList(pageIndex, pageSize);
		model.addAttribute("pageBean", pageBean);
		for (Student student : pageBean.getList()) {
			System.out.println(student);
		}
		return "student_show";
	}
	
	//分页查询
	@RequestMapping("/seacherByCondition")
	private String seacherByCondition(SearchByCondition<Student> condition, Model model) {
		
		if (condition.getPageIndex() == null) {
			condition.setPageIndex(1);
		}
		
		condition.setPageSize(3);
		//获得所有的班级，条件查询
		getBanji(model);
		PageBean<Student> pageBean = studentService.pageListByCondition(condition);
		model.addAttribute("pageBean", pageBean);
		model.addAttribute("condition", condition);
		for (Student student : pageBean.getList()) {
			System.out.println(student + "---");
		}
		return "student_show";
	}
	
	//跳转添加学生jsp
	@RequestMapping("/toAddStudent")
	private String toAddStudent(Model model) {
		
		//获得所有班级
		getBanji(model);
		return "student_add";
	}
	
	//添加学生
	@RequestMapping("/addStudent")
	private String addStudent(Student student) {
		
		System.out.println("添加学生得信息：" + student);
		studentService.addStudent(student);
		return "redirect:pageList.action";
	}
	
	//跳转更改学生信息界面
	@RequestMapping("/toUpdate")
	private String toUpdate(int id, Model model) {
		
		//获得所有班级
		getBanji(model);
		Student student = studentService.findById(id);
		System.out.println("通过ID查询到的学生信息" + student);
		model.addAttribute("student", student);
		return "student_update";
	}
	
	//更改学生信息
	@RequestMapping("/update")
	private String update(Student student) {
		
		System.out.println("#####跟新后的学生的信息#####" + student);
		boolean result = studentService.update(student);
		return "redirect:pageList.action";
	}
	
	
	//删除学生
	@RequestMapping("/delStudent")
	private String delStudent(int id) {
		
		boolean result = studentService.delStudent(id);
		return "redirect:pageList.action";
	}
	
	//获得所有班级
	private void getBanji(Model model) {
		
		List<Banji> bList = banjiService.findAll();
		model.addAttribute("blist", bList);
	}
}
