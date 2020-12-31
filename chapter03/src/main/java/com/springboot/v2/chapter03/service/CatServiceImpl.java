package com.springboot.v2.chapter03.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CatServiceImpl implements AnimalService {

	@Override
	public void use() {
		System.out.println("猫【" + CatServiceImpl.class.getSimpleName()+"】是抓老鼠。");
	}

}
