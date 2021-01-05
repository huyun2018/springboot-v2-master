package com.springboot.v2.chapter06.service;

import com.springboot.v2.chapter06.pojo.User;

import java.util.List;

public interface UserService {

    int insertUser(User user);

    int insertUser1(User user);

    int insertUsers(List<User> userList);

    User getUser(Long id);
}
