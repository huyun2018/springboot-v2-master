package com.springboot.v2.chapter07.service;


import com.springboot.v2.chapter07.pojo.User;

import java.util.List;

/**** imports ****/
public interface UserService {
    // 获取单个用户
    User getUser(Long id);
    
    // 保存用户
    User insertUser(User user);
    
    // 修改用户，指定MyBatis的参数名称
    User updateUserName(Long id, String userName);
    
    // 查询用户，指定MyBatis的参数名称
    List<User> findUsers(String userName, String note);    
    
    // 删除用户
    int deleteUser(Long id);  
}