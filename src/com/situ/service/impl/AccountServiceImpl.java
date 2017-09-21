package com.situ.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.situ.dao.AccountDao;
import com.situ.service.IAccountService;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

	@Resource(name="accountDao")
	private AccountDao accountDao;
	
	@Override
	public void transfer(int inuser, int outuser, double money) {
		accountDao.in(inuser, money);
//		int i = 1/0;
		accountDao.out(outuser, money);
	}

}
