//package com.springboot.v2.chapter06.service.impl;
//
//import com.springboot.v2.chapter06.pojo.User;
//import com.springboot.v2.chapter06.service.JdbcService;
//import org.apache.ibatis.session.TransactionIsolationLevel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//@Service
//public class JdbcServiceImpl implements JdbcService {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Override
//    public int insertUser(User user) {
//        Connection conn = null;
//        int result = 0;
//        try{
//            //获取连接
//            conn = dataSource.getConnection();
//            //开启事务
//            conn.setAutoCommit(false);
//            //设置隔离级别
//            conn.setTransactionIsolation(TransactionIsolationLevel.READ_COMMITTED.getLevel());
//            PreparedStatement ps = conn.prepareStatement("insert into t_user(user_name,note) values(?,?)");
//            ps.setString(1,user.getUserName());
//            ps.setString(2,user.getNote());
//            result = ps.executeUpdate();
//            conn.commit();
//        }catch (Exception e){
//            e.printStackTrace();
//            if(conn != null){
//                try{
//                    conn.rollback();
//                }catch (SQLException e1){
//                    e1.printStackTrace();
//                }
//            }
//        }finally {
//            try {
//                if(conn != null && !conn.isClosed()){
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return result;
//    }
//}
