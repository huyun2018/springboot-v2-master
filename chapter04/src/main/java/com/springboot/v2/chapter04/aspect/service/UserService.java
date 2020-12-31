package com.springboot.v2.chapter04.aspect.service;


import com.springboot.v2.chapter04.aspect.pojo.User;

public interface UserService {
	
	public void printUser();

	public void printUser(User user);
	
	public void manyAspects();
}
