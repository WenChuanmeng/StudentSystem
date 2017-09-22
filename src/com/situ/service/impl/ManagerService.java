package com.situ.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.dao.ManagerDao;
import com.situ.pojo.Course;
import com.situ.pojo.Student;
import com.situ.service.IManagerService;

@Service("managerService")
public class ManagerService implements IManagerService {

	@Resource(name="")
	private ManagerDao managerDao;

	@Override
	public boolean delCourse(Integer bid, Integer cid) {
		int result = managerDao.delCourse(bid, cid);
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Course> findAllCourse() {
		
		return managerDao.findAllCourse();
	}

	@Override
	public boolean addCourse(Integer bid, Integer[] cids) {
		
		int result = 0; 
		for (int i = 0; i < cids.length; i++) {
			result = managerDao.addCourse(bid, cids[i]);
			result++;
		}
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Student findBySno(String sno) {
		
		return managerDao.findBySno(sno);
	}

}
