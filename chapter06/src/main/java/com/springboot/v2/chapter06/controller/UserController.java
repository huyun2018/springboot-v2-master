package com.springboot.v2.chapter06.controller;

import com.springboot.v2.chapter06.pojo.User;
import com.springboot.v2.chapter06.service.UserBatchService;
import com.springboot.v2.chapter06.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserBatchService userBatchService;

    @RequestMapping(value="/save", method = RequestMethod.POST)
    @ResponseBody
    public int save(@RequestBody User user){
        return userService.insertUser(user);
    }


    @RequestMapping(value="/getUser", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(Long id){
        return userService.getUser(id);
    }

    @RequestMapping(value="/insertUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertUser(@RequestBody User user){
        int update = userService.insertUser(user);
        Map<String,Object> result = new HashMap<>();
        result.put("success",update == 1);
        result.put("user",user);
        return result;
    }


    @RequestMapping(value="/insertUserBatch",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertUserBatch(@RequestBody List<User> userList){
        int update = userBatchService.insertUsers(userList);
        Map<String,Object> result = new HashMap<>();
        result.put("success",update == userList.size());
        result.put("count",update);
        return result;
    }


    @RequestMapping(value="/insertUsers",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertUsers(@RequestBody List<User> userList){
        int update = userService.insertUsers(userList);
        Map<String,Object> result = new HashMap<>();
        result.put("success",update == userList.size());
        result.put("count",update);
        return result;
    }


}
