package com.springboot.v2.chapter12.service.impl;

import java.util.List;

import com.springboot.v2.chapter12.dao.RoleDao;
import com.springboot.v2.chapter12.dao.UserDao;
import com.springboot.v2.chapter12.pojo.DatabaseRole;
import com.springboot.v2.chapter12.pojo.DatabaseUser;
import com.springboot.v2.chapter12.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service

public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserDao userDao = null;
	@Autowired
	private RoleDao roleDao = null;

	@Override
	@Cacheable(value = "redisCache", key = "'redis_user_'+#userName")
	@Transactional
	public DatabaseUser getUserByName(String userName) {
		return userDao.getUser(userName);
	}

	@Override
	@Cacheable(value = "redisCache", key = "'redis_user_role_'+#userName")
	@Transactional
	public List<DatabaseRole> findRolesByUserName(String userName) {
		return roleDao.findRolesByUserName(userName);
	}

}
