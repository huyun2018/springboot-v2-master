package com.springboot.v2.proxydemo.cglibpattern.service;

/**
 * 目标对象,没有实现任何接口
 */
public class UserService {
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
