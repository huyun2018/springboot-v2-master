package com.springboot.v2.chapter04;

import com.springboot.v2.chapter04.aspect.MyAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication//(scanBasePackages = {"com.springboot.v2.chapter04.aspect.*"})
public class Chapter04Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter04Application.class, args);
    }

//    @Bean(name = "myAspect")
//    public MyAspect initMyAspect() {
//        return new MyAspect();
//    }

}
