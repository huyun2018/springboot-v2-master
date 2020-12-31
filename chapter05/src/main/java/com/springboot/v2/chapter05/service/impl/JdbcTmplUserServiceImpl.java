//package com.springboot.v2.chapter05.service.impl;
//
//import com.springboot.v2.chapter05.enums.SexEnum;
//import com.springboot.v2.chapter05.pojo.User;
//import com.springboot.v2.chapter05.service.JdbcTmplUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Service;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.List;
//
//@Service
//public class JdbcTmplUserServiceImpl implements JdbcTmplUserService {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    private RowMapper<User> getUserMapper(){
//        RowMapper<User> userRowMapper = (ResultSet rs, int rownum)->{
//            User user = new User();
//            user.setId(rs.getLong("id"));
//            user.setUserName(rs.getString("user_name"));
//            int sexId = rs.getInt("sex");
//            SexEnum sex = SexEnum.getEnumById(sexId);
//            user.setSex(sex);
//            user.setNote(rs.getString("note"));
//            return user;
//        };
//       return userRowMapper;
//    }
//
//
//
//
//    @Override
//    public User getUser(Long id) {
//        // 执行的SQL
//        String sql = " select id, user_name, sex, note from t_user where id = ?";
//        // 参数
//        Object[] params = new Object[] { id };
//        User user = jdbcTemplate.queryForObject(sql, params, getUserMapper());
//        return user;
//    }
//
//    @Override
//    public List<User> findUsers(String userName, String note) {
//        // 执行的SQL
//        String sql = " select id, user_name, sex, note from t_user " + "where user_name like concat('%', ?, '%') "
//                + "and note like concat('%', ?, '%')";
//        // 参数
//        Object[] params = new Object[] { userName, note };
//        // 使用匿名类实现
//        List<User> userList = jdbcTemplate.query(sql, params, getUserMapper());
//        return userList;
//    }
//
//    @Override
//    public int insertUser(User user) {
//        String sql = " insert into t_user (user_name, sex, note) values( ? , ?, ?)";
//        return jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote());
//    }
//
//    @Override
//    public int updateUser(User user) {
//        // 执行的SQL
//        String sql = " update t_user set user_name = ?, sex = ?, note = ?  " + " where id = ?";
//        return jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote(), user.getId());
//    }
//
//    @Override
//    public int deleteUser(Long id) {
//        // 执行的SQL
//        String sql = " delete from t_user where id = ?";
//        return jdbcTemplate.update(sql, id);
//    }
//
//
//    public User getUser2(Long id) {
//        // 通过Lambda表达式使用StatementCallback
//        User result = this.jdbcTemplate.execute((Statement stmt) -> {
//            String sql1 = "select count(*) total from t_user where id= " + id;
//            ResultSet rs1 = stmt.executeQuery(sql1);
//            while (rs1.next()) {
//                int total = rs1.getInt("total");
//                System.out.println(total);
//            }
//            // 执行的SQL
//            String sql2 = " select id, user_name, sex, note from t_user"
//                    + " where id = " + id;
//            ResultSet rs2 = stmt.executeQuery(sql2);
//            User user = null;
//            while (rs2.next()) {
//                int rowNum = rs2.getRow();
//                user= getUserMapper().mapRow(rs2, rowNum);
//            }
//            return user;
//        });
//        return result;
//    }
//
//    public User getUser3(Long id) {
//        // 通过Lambda表达式使用ConnectionCallback接口
//        return this.jdbcTemplate.execute((Connection conn) -> {
//            String sql1 = " select count(*) as total from t_user"
//                    + " where id = ?";
//            PreparedStatement ps1 = conn.prepareStatement(sql1);
//            ps1.setLong(1, id);
//            ResultSet rs1 = ps1.executeQuery();
//            while (rs1.next()) {
//                System.out.println(rs1.getInt("total"));
//            }
//            String sql2 = " select id, user_name, sex, note from t_user "
//                    + "where id = ?";
//            PreparedStatement ps2 = conn.prepareStatement(sql2);
//            ps2.setLong(1, id);
//            ResultSet rs2 = ps2.executeQuery();
//            User user = null;
//            while (rs2.next()) {
//                int rowNum = rs2.getRow();
//                user= getUserMapper().mapRow(rs2, rowNum);
//            }
//            return user;
//        });
//    }
//}
