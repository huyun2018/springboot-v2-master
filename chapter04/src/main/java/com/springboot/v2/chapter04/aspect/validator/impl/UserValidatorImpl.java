package com.springboot.v2.chapter04.aspect.validator.impl;


import com.springboot.v2.chapter04.aspect.pojo.User;
import com.springboot.v2.chapter04.aspect.validator.UserValidator;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {

	@Override
	public boolean validate(User user) {
		System.out.println("引入新的接口："+ UserValidator.class.getSimpleName());
		if(user == null){
			System.err.println("参数为空！");
			return false;
		}
		return true;
	}

}
