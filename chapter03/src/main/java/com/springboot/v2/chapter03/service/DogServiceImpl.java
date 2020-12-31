package com.springboot.v2.chapter03.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
public class DogServiceImpl implements AnimalService {

	@Override
	public void use() {
		System.out.println("狗【" + DogServiceImpl.class.getSimpleName()+"】是看门用的。");
	}

}
