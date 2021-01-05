package com.springboot.v2.chapter06.dao;

import com.springboot.v2.chapter06.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

	User getUser(Long id);

	int insertUser(User user);

}