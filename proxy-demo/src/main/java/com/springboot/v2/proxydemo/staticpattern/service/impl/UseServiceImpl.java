package com.springboot.v2.proxydemo.staticpattern.service.impl;


import com.springboot.v2.proxydemo.staticpattern.IUserService;

public class UseServiceImpl implements IUserService {
    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
