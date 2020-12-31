package com.springboot.v2.chapter03.test;

import com.springboot.v2.chapter03.config.AppConfig;
import com.springboot.v2.chapter03.pojo.User;
import com.springboot.v2.chapter03.service.PersonService;
import com.springboot.v2.chapter03.service.PersonServiceImpl;
import com.springboot.v2.other.pojo.Squirrel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Slf4j
public class IocTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx  = new AnnotationConfigApplicationContext(AppConfig.class);
//        User user = ctx.getBean(User.class);
//        log.info("userId:{}",user.getId());
//
//        User2 user2 = ctx.getBean(User2.class);
//        log.info("user2:{}",user2);
//        User2 user3 = ctx.getBean(User2.class);
//        log.info("user3:{}",user3);
//        log.info("user2 == user3:{}",user2.equals(user3));
//
//
//        UserService userService = ctx.getBean(UserService.class);
//        userService.printUser(user);
//
//        DataSource dataSource = ctx.getBean(DataSource.class);//(DataSource) ctx.getBean("dataSource");
//        Connection connection = null;
//        try {
//            //2. 获得数据库连接
//            connection = dataSource.getConnection();
//            //3. 预编译
//            String sql  = "INSERT INTO t_user(user_name,note) values(?,?)";
//            PreparedStatement ptmt = connection.prepareStatement(sql); //预编译SQL，减少sql执行
//            ptmt.setString(1, user.getUserName());
//            ptmt.setString(2, user.getNote());
//            //执行
//            ptmt.execute();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        Squirrel squirrel = ctx.getBean(Squirrel.class);
        squirrel.use();
        ctx.close();

    }

}
