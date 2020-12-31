//package com.springboot.v2.chapter05.controller;
//
//import com.springboot.v2.chapter05.pojo.User;
//import com.springboot.v2.chapter05.service.JdbcTmplUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    private JdbcTmplUserService jdbcTmplUserService;
//
//
//    @RequestMapping("/query")
//    @ResponseBody
//    public User query(Long id) {
//        User user = jdbcTmplUserService.getUser(id);
//        return user;
//    }
//
//
//}
