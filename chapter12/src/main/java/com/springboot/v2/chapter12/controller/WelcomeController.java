package com.springboot.v2.chapter12.controller;

import com.springboot.v2.chapter12.pojo.DatabaseUser;
import com.springboot.v2.chapter12.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WelcomeController {
	
	@Autowired
	private UserRoleService userRoleService = null;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/user/details")
	@ResponseBody
	public DatabaseUser getUser(String userName) {
		return userRoleService.getUserByName(userName);
	}

//	@GetMapping("/login/page")
//	public String loginPage() {
//		return "login";
//	}

	@GetMapping("/user/welcome")
	public String userWelcome() {
		return "welcome";
	}
	
	@GetMapping("/admin/welcome")
	public String adminWelcome() {
		return "welcome";
	}
	
	@GetMapping("/admin/welcome1")
	public String adminWelcome1() {
		return "welcome";
	}
	
	@GetMapping("/admin/welcome2")
	public String adminWelcome2() {
		return "welcome";
	}
	
	@GetMapping("/csrf/form")
	public String csrfPage() {
		return "csrf_form";
	}
	
	@PostMapping("/csrf/commit")
	@ResponseBody
	public Map<String, String> csrfCommit(String name, String describe) {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("describe", describe);
		return map;
	}
	
}
