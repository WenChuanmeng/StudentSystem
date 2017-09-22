package com.situ.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.dao.AdminDao;
import com.situ.pojo.User;
import com.situ.service.IAdminService;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

@Service("adminService")
public class AdminServiceImpl implements IAdminService {

	@Resource(name="adminDao")
	private AdminDao adminDao;
	
	@Override
	public PageBean<User> pageList(Integer pageIndex, Integer pageSize) {
		
		PageBean<User> pageBean = new PageBean<User>();
		
		//设置当前页
		pageBean.setPageIndex(pageIndex);
		//设置这个页有多少条数据
		pageBean.setPageSize(pageSize);
		//一共有多少条数据
		int totalSize = (int) adminDao.totalSize();
		pageBean.setTotalSize(totalSize);
		//一共有多少页
		int totalPage = (int) Math.ceil(1.0 * totalSize / pageSize);
		pageBean.setTotalPage(totalPage);
		int index = (pageIndex - 1) * pageSize;
		List<User> list = adminDao.pageList(index, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public PageBean<User> conditionPageList(SearchByCondition<User> condition) {
		
		PageBean<User> pageBean = new PageBean<User>();
		
		//设置当前页
		pageBean.setPageIndex(condition.getPageIndex());
		//设置这个页有多少条数据
		pageBean.setPageSize(condition.getPageSize());
		//一共有多少条数据
		int totalSize = (int) adminDao.totalSizeByCondition(condition);
		pageBean.setTotalSize(totalSize);
		//一共有多少页
		int totalPage = (int) Math.ceil(1.0 * totalSize / condition.getPageSize());
		pageBean.setTotalPage(totalPage);
		
		condition.setPageIndex((condition.getPageIndex() - 1) * condition.getPageSize());
		List<User> list = adminDao.seacherByCondition(condition);
		pageBean.setList(list);
		
		return pageBean;
	}

	@Override
	public boolean addUser(User user) {
		
		int i = adminDao.addUser(user);
		
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delUser(int uid) {
		
		int i = adminDao.delUser(uid);
		
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User seacherById(int uid) {
		
		return adminDao.searchById(uid);
	}

	@Override
	public boolean update(User user) {
		
		int i = adminDao.updateUSer(user);
		
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

}
