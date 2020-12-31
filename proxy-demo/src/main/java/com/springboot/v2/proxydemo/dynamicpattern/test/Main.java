package com.springboot.v2.proxydemo.dynamicpattern.test;

import com.springboot.v2.proxydemo.dynamicpattern.factory.ProxyFactory;
import com.springboot.v2.proxydemo.dynamicpattern.service.IUserService;
import com.springboot.v2.proxydemo.dynamicpattern.service.impl.UseServiceImpl;

public class Main {
    public static void main(String[] args) {
        // 目标对象
        IUserService target = new UseServiceImpl();
        // 【原始的类型 class com.springboot.v2.proxydemo.dynamicpattern.service.impl.UseServiceImpl】
        System.err.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserService proxy = (IUserService) new ProxyFactory(target).getProxyInstance();
        // class class com.sun.proxy.$Proxy0   内存中动态生成的代理对象
        System.err.println(proxy.getClass());
        // 执行方法【代理对象】
        proxy.save();
    }
}
