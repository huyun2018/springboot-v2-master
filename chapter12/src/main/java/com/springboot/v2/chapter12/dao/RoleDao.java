package com.springboot.v2.chapter12.dao;

import java.util.List;

import com.springboot.v2.chapter12.pojo.DatabaseRole;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface RoleDao {
	
	public List<DatabaseRole> findRolesByUserName(String userName);
}
