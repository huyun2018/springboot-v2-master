package com.springboot.v2.chapter04.intercept;

import com.springboot.v2.chapter04.invoke.Invocation;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationTargetException;
@Slf4j
public class MyInterceptor implements Interceptor {
    @Override
    public boolean before() {
        log.info("before ......");
        return true;
    }

    @Override
    public void after() {
        log.info("after ......");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        log.info("around before ......");
        Object obj = invocation.proceed();
        log.info("around after ......");
        return obj;
    }

    @Override
    public void afterReturning() {
        log.info("afterReturning ......");
    }

    @Override
    public void afterThrowing() {
        log.info("afterThrowing ......");
    }

    @Override
    public boolean useAround() {
        return true;
    }
}
