package com.springboot.v2.chapter05.service;

import com.springboot.v2.chapter05.pojo.TUser;

public interface MyBatisUserService {

    TUser getUser(Long id);
}
