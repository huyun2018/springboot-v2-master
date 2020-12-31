package com.springboot.v2.proxydemo.staticpattern.service.proxy;

import com.springboot.v2.proxydemo.staticpattern.IUserService;

/**
 * 代理对象,静态代理
 */
public class UserServiceProxy implements IUserService {
    //接收保存目标对象
    private IUserService target;

    public UserServiceProxy(IUserService target) {
        this.target = target;
    }

    public void save() {
        System.out.println("开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}
