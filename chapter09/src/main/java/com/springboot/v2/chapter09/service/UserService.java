package com.springboot.v2.chapter09.service;


import com.springboot.v2.chapter09.pojo.User;

import java.util.List;

public interface UserService {
	
	User getUser(Long id);

	List<User> findUsers(String userName, String note);

}
