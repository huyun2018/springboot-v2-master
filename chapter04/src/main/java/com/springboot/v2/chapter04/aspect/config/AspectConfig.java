package com.springboot.v2.chapter04.aspect.config;

import com.springboot.v2.chapter04.aspect.MyAspect;
import com.springboot.v2.chapter04.aspect.MyAspect1;
import com.springboot.v2.chapter04.aspect.MyAspect2;
import com.springboot.v2.chapter04.aspect.MyAspect3;
import com.springboot.v2.chapter04.aspect.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//启动@AspectJ切面编程
@EnableAspectJAutoProxy
//定义扫描包
@ComponentScan(basePackages = {"com.springboot.v2.chapter04.aspect.*"}, basePackageClasses = UserServiceImpl.class)
public class AspectConfig {

	@Bean(name = "myAspect")
	public MyAspect initMyAspect() {
	    return new MyAspect();
	}
	// 定义切面
	@Bean(name = "myAspect2")
	public MyAspect2 initMyAspect2() {
		return new MyAspect2();
	}

	// 定义切面
	@Bean(name = "myAspect1")
	public MyAspect1 initMyAspect1() {
		return new MyAspect1();
	}

	// 定义切面
	@Bean(name = "myAspect3")
	public MyAspect3 initMyAspect3() {
		return new MyAspect3();
	}
}
