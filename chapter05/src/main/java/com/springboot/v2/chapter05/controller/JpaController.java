//package com.springboot.v2.chapter05.controller;
//
//import com.springboot.v2.chapter05.dao.JpaUserRepository;
//import com.springboot.v2.chapter05.pojo.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/jpa")
//public class JpaController {
//    @Autowired
//    private JpaUserRepository jpaUserRepository;
//
//    @RequestMapping("/getUser")
//    @ResponseBody
//    public User getUser(Long id) {
//        User user = jpaUserRepository.findById(id).get();
//        return user;
//    }
//
//    @RequestMapping("/findUsers")
//    @ResponseBody
//    public List<User> findUsers(String userName, String note) {
//        List<User> userList = jpaUserRepository.findUsers(userName, note);
//        return userList;
//    }
//
//    @RequestMapping("/getUserById")
//    @ResponseBody
//    public User getUserById(Long id) {
//        // 使用JPA接口查询对象
//        User user = jpaUserRepository.getUserById(id);
//        return user;
//    }
//
//    @RequestMapping("/findByUserNameLike")
//    @ResponseBody
//    public List<User> findByUserNameLike(String userName) {
//        // 使用JPA接口查询对象
//        List<User> userList = jpaUserRepository.findByUserNameLike("%" + userName + "%");
//        return userList;
//    }
//
//    @RequestMapping("/findByUserNameLikeOrNoteLike")
//    @ResponseBody
//    public List<User> findByUserNameLikeOrNoteLike(String userName, String note) {
//        String userNameLike = "%" + userName + "%";
//        String noteLike = "%" + note + "%";
//        // 使用JPA接口查询对象
//        List<User> userList = jpaUserRepository.findByUserNameLikeOrNoteLike(userNameLike, noteLike);
//        return userList;
//    }
//}
