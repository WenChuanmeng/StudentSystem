package com.situ.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.pojo.User;
import com.situ.service.IAdminService;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

@Controller
@RequestMapping("user")
public class AdminController {

	@Resource(name="adminService")
	private IAdminService adminService;
	
	//查询全部的USer并进行分页
	@RequestMapping("/pageList")
	private String pageList(Integer pageIndex, Integer pageSize, Model model) {
		
		if (pageIndex == null) {
			pageIndex = 1;
		}
		
		pageSize = 5;
		
		//获得user
		PageBean<User> pageBean = adminService.pageList(pageIndex, pageSize);
		model.addAttribute("pageBean", pageBean);
		return "admin_show";
	}

	//根据条件查询user并进行分页
	@RequestMapping("/seacherByCondition")
	private String seacherByCondition(SearchByCondition<User> condition, Model model) {
		
		
		
		if (condition.getPageIndex() == null) {
			condition.setPageIndex(1);
		}
		
		condition.setPageSize(5);
		
		
		PageBean<User> pageBean = adminService.conditionPageList(condition);
		model.addAttribute("condition", condition);
		model.addAttribute("pageBean", pageBean);
		
		return "admin_show";
	}
	
		//跳转到添加学生jsp页面
	@RequestMapping("/toAddUser")
	private String toAddUser() {
		return "admin_add";
	}
		
	//添加学生
	@RequestMapping("/addUser")
	private String addUser(User user) {
		
		boolean result = adminService.addUser(user);
		return "redirect:pageList.action";
	}
	
	//删除学生
	@RequestMapping("/delUser")
	private String delUser(int id) {
		
		boolean result = adminService.delUser(id);
		
		return "redirect:pageList.action";
	}
	
	@RequestMapping("onlineUser")
	private String onlineUser() {
		
		return "admin_online_User_show";
	}
	
	@RequestMapping("toUpdate")
	private String toUpdate(int id, Model model) {
		
		User user = adminService.seacherById(id);
		model.addAttribute("user", user);
		return "admin_update";
	}
	
	@RequestMapping("/update")
	private String update(User user){
		
		boolean result = adminService.update(user);
		return "redirect:pageList.action";
	}
}
