package com.springboot.v2.proxydemo.staticpattern.test;

import com.springboot.v2.proxydemo.staticpattern.IUserService;
import com.springboot.v2.proxydemo.staticpattern.service.impl.UseServiceImpl;
import com.springboot.v2.proxydemo.staticpattern.service.proxy.UserServiceProxy;

public class Main {
    public static void main(String[] args) {
        //目标对象
        IUserService target = new UseServiceImpl();
        //代理对象,把目标对象传给代理对象,建立代理关系
        UserServiceProxy proxy = new UserServiceProxy(target);
        proxy.save();//执行的是代理的方法
    }
}
