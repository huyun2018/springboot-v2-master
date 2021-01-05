//package com.springboot.v2.chapter06.controller;
//
//import com.springboot.v2.chapter06.pojo.User;
//import com.springboot.v2.chapter06.service.JdbcService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//@RequestMapping("/jdbc")
//public class JdbcController {
//
//    @Autowired
//    private JdbcService jdbcService;
//
//    @RequestMapping(value="/save", method = RequestMethod.POST)
//    @ResponseBody
//    public String save(User user){
//        jdbcService.insertUser(user);
//        return "success";
//    }
//}
