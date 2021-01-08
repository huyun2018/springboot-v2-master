package com.springboot.v2.chapter12.dao;

import com.springboot.v2.chapter12.pojo.DatabaseUser;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao {
	
	public DatabaseUser getUser(String userName);
}
