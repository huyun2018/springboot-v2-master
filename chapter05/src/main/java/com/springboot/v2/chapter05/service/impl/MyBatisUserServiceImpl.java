package com.springboot.v2.chapter05.service.impl;

import com.springboot.v2.chapter05.dao.MyBatisUserDao;
import com.springboot.v2.chapter05.pojo.TUser;
import com.springboot.v2.chapter05.service.MyBatisUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {

    @Autowired
    private MyBatisUserDao myBatisUserDao;

    @Override
    public TUser getUser(Long id) {
        return myBatisUserDao.findUserById(id);
    }
}
