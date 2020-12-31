package com.springboot.v2.chapter05.dao;

import com.springboot.v2.chapter05.pojo.TUser;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBatisUserDao {

	TUser findUserById(Long id);

}