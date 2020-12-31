package com.springboot.v2.chapter05;

import com.springboot.v2.chapter05.dao.MyBatisUserDao;
import com.springboot.v2.chapter05.enums.SexEnum;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@SpringBootApplication
////定义JPA接口扫描包路径
//@EnableJpaRepositories(basePackages = "com.springboot.v2.chapter05.dao")
////定义实体Bean扫描包路径
//@EntityScan(basePackages = "com.springboot.v2.chapter05.pojo")

@MapperScan(basePackages="com.springboot.v2.chapter05", annotationClass = Repository.class)
public class Chapter05Application {

    public static void main(String[] args) {
        SpringApplication.run(Chapter05Application.class, args);
    }


    @Autowired
    private SqlSessionFactory sqlSessionFactory;

//    // 方式一：MapperFactoryBean定义一个MyBatis的Mapper接口
//	@Bean
//	public MapperFactoryBean<MyBatisUserDao> initMyBatisUserDao() {
//	     MapperFactoryBean<MyBatisUserDao> bean = new MapperFactoryBean<>();
//	     bean.setMapperInterface(MyBatisUserDao.class);
//	     bean.setSqlSessionFactory(sqlSessionFactory);
//	     TypeHandler<SexEnum> sexTypeHandler = sqlSessionFactory.getConfiguration().getTypeHandlerRegistry().getTypeHandler(SexEnum.class);
//	     return bean;
//	}


//	/***
//	 * 配置MyBatis接口扫描
//	 * @return 返回扫描器
//	 */
//	@Bean
//	public MapperScannerConfigurer mapperScannerConfig() {
//	    // 定义扫描器实例
//		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//	    // 加载SqlSessionFactory,Spring Boot会自动生产，SqlSessionFactory实例
//	   	mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//	    //定义扫描的包
//	    mapperScannerConfigurer.setBasePackage("com.springboot.v2.chapter05.*");
//	    //限定被标注@Repository的接口才被扫描
//	    mapperScannerConfigurer.setAnnotationClass(Repository.class);
//	    //通过继承某个接口限制扫描，一般使用不多
//	    //mapperScannerConfigurer.setMarkerInterface(......);
//	    return mapperScannerConfigurer;
//	}

}
