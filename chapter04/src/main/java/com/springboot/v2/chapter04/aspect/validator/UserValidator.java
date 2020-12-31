package com.springboot.v2.chapter04.aspect.validator;

import com.springboot.v2.chapter04.aspect.pojo.User;

public interface UserValidator {
	
	public boolean validate(User user);
}
