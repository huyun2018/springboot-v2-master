package com.springboot.v2.chapter03.config;

//import com.springboot.v2.chapter03.pojo.User;

import com.springboot.v2.chapter03.condition.DatabaseConditional;
import com.springboot.v2.chapter03.pojo.User;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ImportResource({"classpath*:META-INF/spring/*.xml"})
//@ComponentScan(value = "com.springboot.v2.chapter03.*"/*,lazyInit = true*//*,excludeFilters = {@ComponentScan.Filter(classes = {Service.class})}*/)
public class AppConfig {

//    @Value("${spring.datasource.driver}")
//    private String driver;
//    @Value("${spring.datasource.url}")
//    private String url;
//    @Value("${spring.datasource.username}")
//    private String username;
//    @Value("${spring.datasource.password}")
//    private String password;

    @Bean(name = "user")
    public User initUser() {
        User user = new User();
        user.setId(1L);
        user.setUserName("user_name_1");
        user.setNote("note_1");
        return user;
    }

    @Bean(name = "dataSource", destroyMethod = "close")
    @Conditional(DatabaseConditional.class)
    public DataSource getDataSource(@Value("${spring.datasource.driver}") String driver,
                                    @Value("${spring.datasource.url}") String url,
                                    @Value("${spring.datasource.username}") String username,
                                    @Value("${spring.datasource.password}") String password) {
        Properties props = new Properties();
        props.setProperty("driver", driver);
        props.setProperty("url", url);
        props.setProperty("username", username);
        props.setProperty("password", password);
        DataSource dataSource = null;
        try {
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
