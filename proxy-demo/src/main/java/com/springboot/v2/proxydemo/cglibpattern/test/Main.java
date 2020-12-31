package com.springboot.v2.proxydemo.cglibpattern.test;

import com.springboot.v2.proxydemo.cglibpattern.factory.ProxyFactory;
import com.springboot.v2.proxydemo.cglibpattern.service.UserService;

public class Main {

    public static void main(String[] args) {
        //目标对象
        UserService target = new UserService();
        //代理对象
        UserService proxy = (UserService) new ProxyFactory(target).getProxyInstance();
        //执行代理对象的方法
        proxy.save();
    }

}
