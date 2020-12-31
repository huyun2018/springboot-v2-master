package com.springboot.v2.chapter03.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *                                                                 实现接口BeanNameAware    实现接口BeanFacotoryAware
 *    开始---------->    实例化  ---------->    依赖注入   ---------->   setBeanName---------->  setBeanFactory方法
 *                                                                                                             |
 * @PostConstruct注解方法                                                     实现接口ApplicationContextAware   |
 *  自定义初始化方法<----------- postProcessBeforeInitialization方法<----------- setApplicationContext<----------
 *       |
 *       |实现接口InitilizingBean                                                               @PreDestrory注解方法
 *       afterPropertiesSet方法---------->postProcessAfterInitialization方法---------->生产期---------->自定义销毁方法
 *                                                                                                            |
 *                                                                                    实现接口DisposableBean   |
 *                                                                      结束<-----------destory方法<-----------
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
@Component
public class PersonServiceImpl implements PersonService , BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    //属性
//    @Autowired(required =false)
//    @Qualifier("catServiceImpl")
    private AnimalService animal;

      //构造方法
//    public PersonServiceImpl(@Autowired(required =false) @Qualifier("dogServiceImpl")AnimalService animal){
//        this.animal = animal;
//    }

    @Override
    public void service() {
        this.animal.use();
    }

    //set方法
    @Override
    @Autowired(required =false)
    @Qualifier("dogServiceImpl")
    public void setAnimal(AnimalService animal) {
        System.out.println("延迟依赖注入");
        this.animal = animal;
    }


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用BeanFactoryAware的setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用BeanNameAware的setBeanName");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用InitializingBean的afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用ApplicationContextAware的setApplicationContext");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】调用DisposableBean的destroy");
    }

    @PostConstruct
    public void init(){
        System.out.println("【"+this.getClass().getSimpleName()+"】注解@PostConstruct定义对的自定义初始化方法");
    }

    @PreDestroy
    public void destroy1() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】注解@PreDestroy定义对的自定义销毁方法");
    }



}
