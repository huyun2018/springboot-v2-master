package com.springboot.v2.chapter05.db;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DataSourceShow implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * Spring容器会自动调用这个方法，输入Spring Ioc容器
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println("----------------------------------------------");
        System.out.println(dataSource.getClass().getName());
        System.out.println("----------------------------------------------");
    }
}
