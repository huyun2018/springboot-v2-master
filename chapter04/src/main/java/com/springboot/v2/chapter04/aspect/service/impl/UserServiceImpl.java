package com.springboot.v2.chapter04.aspect.service.impl;

import com.springboot.v2.chapter04.aspect.pojo.User;
import com.springboot.v2.chapter04.aspect.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private User user = null;

    @Override
    public void printUser(User user) {
        if (user == null) {
            throw new RuntimeException("检查用户参数是否为空......");
        }
        System.out.print("id =" + user.getId());
        System.out.print("\tusername =" + user.getUsername());
        System.out.println("\tnote =" + user.getNote());
    }

    @Override
    public void manyAspects() {
        System.out.println("测试多个切面顺序");
    }

    @Override
    public void printUser() {
        if (user == null) {
            throw new RuntimeException("检查用户参数是否为空......");
        }
        System.out.print("id =" + user.getId());
        System.out.print("\tusername =" + user.getUsername());
        System.out.println("\tnote =" + user.getNote());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
