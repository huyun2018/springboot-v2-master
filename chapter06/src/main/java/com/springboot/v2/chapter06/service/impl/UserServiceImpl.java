package com.springboot.v2.chapter06.service.impl;

import com.springboot.v2.chapter06.dao.UserDao;
import com.springboot.v2.chapter06.pojo.User;
import com.springboot.v2.chapter06.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRES_NEW,timeout = 1)
//    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.NESTED,timeout = 1)
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.NESTED,timeout = 1)
    public int insertUser1(User user) {
        return userDao.insertUser(user);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED,timeout = 1)
    public int insertUsers(List<User> userList) {
        int count = 0;
        for(User user:userList){
            count += insertUser(user);
        }
        return count;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
    public User getUser(Long id) {
        return null;
    }


}
