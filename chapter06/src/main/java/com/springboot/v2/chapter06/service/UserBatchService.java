package com.springboot.v2.chapter06.service;

import com.springboot.v2.chapter06.pojo.User;

import java.util.List;

public interface UserBatchService {

    int insertUsers(List<User> userList);
}
