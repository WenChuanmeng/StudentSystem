package com.situ.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.pojo.Banji;
import com.situ.pojo.Course;
import com.situ.pojo.Student;
import com.situ.service.IBanjiService;
import com.situ.service.IManagerService;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

@Controller
@RequestMapping("eduAdmin")
public class ManagerController {

	@Resource(name="banjiService")
	private IBanjiService banjiService;
	
	@Resource(name="managerService")
	private IManagerService managerService;
	
	//进行班级分页
		@RequestMapping("/pageList")
		private String pageList(Integer pageIndex, Integer pageSize, Model model) {
			
			if (pageIndex == null) {
				pageIndex = 1;
			}
			
			pageSize = 5;
			
			//获得班级的人数
			getBanjiPersonNum(model);
			PageBean<Banji> pageBean = banjiService.pageList(pageIndex, pageSize);
			model.addAttribute("pageBean", pageBean);
			for (Banji banji : pageBean.getList()) {
				System.out.println(banji);
				
			}
			return "edu_admin_show";
		}
		
	//对班级的进行分页查询
	@RequestMapping("/seacherByCondition")
	private String seacherByCondition(SearchByCondition<Banji> condition, Model model) {
		
		if (condition.getPageIndex() == null) {
			condition.setPageIndex(1);
		}
		
		condition.setPageSize(5);
		getBanjiPersonNum(model);
		PageBean<Banji> pageBean = banjiService.pageListByCondition(condition);
		model.addAttribute("condition", condition);
		model.addAttribute("pageBean", pageBean);
		return "edu_admin_show";
	}
		
	//进行删除课程
	@RequestMapping("delCourse")
	private String delCourse(Integer bid, Integer cid) {
		
		managerService.delCourse(bid, cid);
		return "redirect:pageList.action";
	}
	
	//添加课程
	@RequestMapping("/toBanjiAddCourse")
	private String toBanjiAddCourse(Model model){
		
		List<Banji> bList = banjiService.findAll();
		List<Course> cList = managerService.findAllCourse();
		model.addAttribute("bList", bList);
		model.addAttribute("cList", cList);
		return "edu_admin_add";
	}
	
	//查询学生选课情况
	@RequestMapping("/toStuSelectCourses")
	private String toStuSelectCourses(){
		
		return "edu_admin_stu_show";
	}
	
	//查询学生选课情况
	@RequestMapping("/stuSelectCourses")
	private String stuSelectCourses(String sno, Model model) {
	
		Student student = managerService.findBySno(sno);
		model.addAttribute("student", student);
		return "edu_admin_stu_show";
	}
	
	//添加课程
	@RequestMapping("/addCourses")
	private String addCourses(Integer bid, Integer[] cids) {
		
		boolean result = managerService.addCourse(bid, cids);
		return "redirect:pageList.action";
	}
	
	//查询班级的人数
	private void getBanjiPersonNum(Model model) {
		List<Banji> pList = banjiService.getBanjiPersonNum();
		model.addAttribute("pList", pList);
	}
}
