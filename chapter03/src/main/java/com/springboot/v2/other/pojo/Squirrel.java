package com.springboot.v2.other.pojo;


import com.springboot.v2.chapter03.service.AnimalService;

public class Squirrel implements AnimalService {

	@Override
	public void use() {
		System.out.println("松鼠可以采集松果");
	}

}
