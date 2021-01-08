package com.springboot.v2.chapter12.service;

import com.springboot.v2.chapter12.pojo.DatabaseRole;
import com.springboot.v2.chapter12.pojo.DatabaseUser;

import java.util.List;


public interface UserRoleService {

	public DatabaseUser getUserByName(String userName);

	public List<DatabaseRole> findRolesByUserName(String userName);
}
