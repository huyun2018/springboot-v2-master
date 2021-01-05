package com.springboot.v2.chapter06;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

@SpringBootApplication
@MapperScan(basePackages="com.springboot.v2.chapter06", annotationClass = Repository.class)
public class Chapter06Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter06Application.class, args);
    }

    // 注入事务管理器，它由Spring Boot自动生成
    @Autowired
    private PlatformTransactionManager transactionManager;

    @PostConstruct
    public void viewTransactionManager(){
        //TODO:
        System.out.println(transactionManager.getClass().getName());
    }

}
