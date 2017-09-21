package com.situ.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.dao.BanjiDao;
import com.situ.pojo.Banji;
import com.situ.pojo.Student;
import com.situ.service.IBanjiService;
import com.situ.vo.PageBean;
import com.situ.vo.SearchByCondition;

@SuppressWarnings("all")
@Service("banjiService")
public class BanjiServiceImpl implements IBanjiService {

	@Resource(name="banjiDao")
	private BanjiDao banjiDao;
	
	@Override
	public List<Banji> findAll() {
		
		return banjiDao.findAll();
	}
	
	@Override
	public PageBean<Banji> pageList(Integer pageIndex, Integer pageSize) {
		PageBean<Banji> pageBean = new PageBean<Banji>();
		
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		int totalSize = banjiDao.totalSize();//获得班级的个数
		int totalPage = (int) Math.ceil(1.0 * totalSize / pageSize);//获得总页数
		pageBean.setTotalSize(totalSize);
		pageBean.setTotalPage(totalPage);
		List<Banji> list = banjiDao.pageList(pageIndex, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}


	@Override
	public PageBean<Banji> pageListByCondition(SearchByCondition<Banji> condition) {
		
		PageBean<Banji> pageBean = new PageBean<Banji>();
		pageBean.setPageIndex(condition.getPageIndex());
		pageBean.setPageSize(condition.getPageSize());
		int totalSize = banjiDao.totalSizeByCondition(condition);
		int totalPage = (int) Math.ceil(1.0 * totalSize / condition.getPageSize());
		pageBean.setTotalSize(totalSize);
		pageBean.setTotalPage(totalPage);
		condition.setPageIndex((condition.getPageIndex() - 1) * condition.getPageSize());
		List<Banji> list = banjiDao.pageListByCondition(condition);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public List<Banji> getBanjiPersonNum() {
		
		return banjiDao.getBanjiPersonNum();
	}

	@Override
	public boolean delBanJi(int id) {
		
		int result = banjiDao.delBanji(id);
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Banji findById(int id) {
		
		return banjiDao.findById(id);
	}

	@Override
	public boolean update(Banji banji) {
		
		int result = banjiDao.update(banji);
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean addBanJi(Banji banji) {
		
		int result = banjiDao.addBanJi(banji);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
}
