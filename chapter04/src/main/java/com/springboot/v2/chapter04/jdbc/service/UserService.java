package com.springboot.v2.chapter04.jdbc.service;

import com.springboot.v2.chapter04.jdbc.dao.UserDao;
import com.springboot.v2.chapter04.jdbc.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserService {

    public int insertUser() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("user_name_1");
        user.setNote("note_1");
        Connection conn = null;
        int result = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring_boot", "root", "123456");
            //非自动提交事务
            conn.setAutoCommit(false);
            result = userDao.insertUser(conn, user);
            //提交事务
            conn.commit();
        } catch (Exception e) {
            try {
                //回滚事务
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //释放数据连接资源
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
