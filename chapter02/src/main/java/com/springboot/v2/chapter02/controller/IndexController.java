package com.springboot.v2.chapter02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        System.out.println("=======请求=======");
        return "index";
    }
}