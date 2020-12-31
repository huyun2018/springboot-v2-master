package com.springboot.v2.chapter04.test;

import com.springboot.v2.chapter04.intercept.MyInterceptor;
import com.springboot.v2.chapter04.proxy.ProxyBean;
import com.springboot.v2.chapter04.service.HelloService;
import com.springboot.v2.chapter04.service.impl.HelloServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService)ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("zhangsan");
        log.info("\n ##################################################################################### \n");
        proxy.sayHello(null);
    }
}
