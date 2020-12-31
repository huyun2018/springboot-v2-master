package com.springboot.v2.chapter04.aspect;

import com.springboot.v2.chapter04.aspect.pojo.User;
import com.springboot.v2.chapter04.aspect.validator.UserValidator;
import com.springboot.v2.chapter04.aspect.validator.impl.UserValidatorImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

    @DeclareParents(value = "com.springboot.v2.chapter04.aspect.service.impl.UserServiceImpl", defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    @Pointcut("execution(* com.springboot.v2.chapter04.aspect.service.impl.UserServiceImpl.printUser(..)) && bean(userServiceImpl) ")

    public void pointCut() {
    }

    @Before("pointCut() && args(user)")
    public void beforeParam(JoinPoint joinPoint,User user) {
        Object[] args = joinPoint.getArgs();
        System.out.println("before ......"+user.toString());
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before ......");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after ......");
    }


    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning ......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing ......");
    }


    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before......");
        jp.proceed();
        System.out.println("around after......");
    }
}
