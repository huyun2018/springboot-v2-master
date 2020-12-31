package com.springboot.v2.chapter04.service.impl;

import com.springboot.v2.chapter04.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
@Slf4j
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {

        if(StringUtils.isBlank(name)){
            log.error("parameter is null!!");
            throw new RuntimeException("parameter is null!!");
        }
        log.info("hello "+name);

    }

}
