package com.situ.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.pojo.Banji;
import com.situ.service.IBanjiService;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

@SuppressWarnings("all")
@Controller
@RequestMapping("banji")
public class BanjiController {

	@Resource(name="banjiService")
	private IBanjiService banjiService;
	
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
		return "banji_show";
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
		return "banji_show";
	}
	
	//删除班级
	@RequestMapping("/delBanJi")
	private String delBanJi(int id) {
		
		boolean result = banjiService.delBanJi(id);
		return "redirect:pageList.action";
	}
	
	//跳转到修改班级的界面
	@RequestMapping("/toUpdate")
	private String toUpdate(int id, Model model) {
		
		Banji banji = banjiService.findById(id);
		model.addAttribute("banji", banji);
		return "banji_update";
	}
	
	//修改班级
	@RequestMapping("/update")
	private String update(Banji banji) {
		boolean result = banjiService.update(banji);
		return "redirect:pageList.action";
	}
	
	//跳转到添加班级
	@RequestMapping("/toAddBanJI")
	private String toAddBanJI() {
		
		return "banji_add";
	}
	
	//添加班级
	@RequestMapping("addBanJi")
	private String addBanJI(Banji banji) {
		System.out.println(banji);
		boolean result = banjiService.addBanJi(banji);
		return "redirect:pageList.action";
	}
	
	
	//查询班级的人数
	private void getBanjiPersonNum(Model model) {
		List<Banji> pList = banjiService.getBanjiPersonNum();
		model.addAttribute("pList", pList);
	}
}
