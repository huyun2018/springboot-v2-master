package com.springboot.v2.chapter08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.springboot.v2.chapter08.repository",repositoryImplementationPostfix = "Stuff")
public class Chapter08Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter08Application.class, args);
    }

}
