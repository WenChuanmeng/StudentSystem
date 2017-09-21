package com.situ.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.situ.service.IAccountService;

@SuppressWarnings("all")
@Controller
@RequestMapping("/a")
public class AccountController {

	@Resource(name="accountService")
	private IAccountService accountService;
	
	@RequestMapping("/b")
	public void testAccount() {
		
		accountService.transfer(1, 2, 500);
	}
}
