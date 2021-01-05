package com.springboot.v2.chapter06.service.impl;

import com.springboot.v2.chapter06.dao.UserDao;
import com.springboot.v2.chapter06.pojo.User;
import com.springboot.v2.chapter06.service.UserBatchService;
import com.springboot.v2.chapter06.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserBatchServiceImpl implements UserBatchService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Override
//    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int insertUsers(List<User> userList) {
        User user1 = new User();
        user1.setUserName("hhhhhhh");
        user1.setNote("zzzzzzzz");
        userService.insertUser1(user1);
        userService.insertUser(userList.get(0));
        int count = 0;
//        for(User user:userList){
//            try{
//                count += userService.insertUser(user);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
        return count;
    }
}
