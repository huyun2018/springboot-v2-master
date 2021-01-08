package com.springboot.v2.chapter09;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;

@SpringBootApplication
@MapperScan(basePackages="com.springboot.v2.chapter09", annotationClass = Repository.class)
public class Chapter09Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter09Application.class, args);
    }

}
