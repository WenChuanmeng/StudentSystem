package com.situ.controller;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
		System.out.println(student.getImgSrc());
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
		
		System.out.println(student.getImgSrc());
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
	
	//批量删除
	@RequestMapping("deletAll")
	private String deletAll(Integer[] selectIds) {
		
		boolean result = studentService.deletAll(selectIds);
		return "redirect:pageList.action";
		
	}
	
	//上传头像
	@RequestMapping("/uploadPic")
	@ResponseBody
	private Map<String, Object> uploadPic(MultipartFile pictureFile) {
		//随机获得name
		String name = UUID.randomUUID().toString().replace("-", "");
		String ext = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		String fileName = name + "." +ext;
		String filePath = "E:\\pic\\" + fileName;
		try {
			pictureFile.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e) {
			
			e.printStackTrace();
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("fileName", fileName);
		return map;
	}
	
	
	//获得所有班级
	private void getBanji(Model model) {
		
		List<Banji> bList = banjiService.findAll();
		model.addAttribute("blist", bList);
	}
}
