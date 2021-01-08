package com.springboot.v2.chapter12.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 注入数据源
     */
    @Autowired
    private DataSource dataSource;


    @Value("${system.user.password.secret}")
    private String secret;

    @Autowired
    private UserDetailsService userDetailsService;



    // 使用用户名称查询密码
    String pwdQuery = " select user_name, pwd, available" + " from t_user where user_name = ?";
    // 使用用户名称查询角色信息
    String roleQuery = " select u.user_name, r.role_name " + " from t_user u, t_user_role ur, t_role r "
            + "where u.id = ur.user_id and r.id = ur.role_id" + " and u.user_name = ?";

    /**
     * 用来配置用户签名服务，主要是user-details机制，你还可以给予用户赋予角色
     * @param auth 签名管理器构造器，用于构建用户具体权限控制
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        /*====================1、内存签名服务====================*/
//         // 密码编码器
//         PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//         // 使用内存存储
//         InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> userConfig = auth.inMemoryAuthentication()
//         // 设置密码编码器
//         .passwordEncoder(passwordEncoder);
//         // 注册用户admin，密码为abc,并赋予USER和ADMIN的角色权限
//         userConfig.withUser("admin")
//         // 可通过passwordEncoder.encode("abc")得到加密后的密码
//         .password("$2a$10$5OpFvQlTIbM9Bx2pfbKVzurdQXL9zndm1SrAjEkPyIuCcZ7CqR6je")
//         .authorities("ROLE_USER", "ROLE_ADMIN");
//
//         // 注册用户myuser，密码为123456,并赋予USER的角色权限
//         userConfig.withUser("myuser")
//         // 可通过passwordEncoder.encode("123456")得到加密后的密码
//         .password("$2a$10$ezW1uns4ZV63FgCLiFHJqOI6oR6jaaPYn33jNrxnkHZ.ayAFmfzLS")
//         .roles("USER");//赋予角色，会自定加入前缀"ROLE_"
//        /*====================1、内存签名服务====================*/

//        /*====================2、数据库验证签名服务====================*/
//         // 密码编码器
//         PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(this.secret);
//         auth.jdbcAuthentication()
//                 .passwordEncoder(passwordEncoder)
//                 .dataSource(dataSource)
//                 .usersByUsernameQuery(pwdQuery)
//                 .authoritiesByUsernameQuery(roleQuery);
//        /*====================2、数据库验证签名服务====================*/


        /*====================3、自定义用户认证服务====================*/
         // 密码编码器
         PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(this.secret);
         auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
        /*====================3、自定义用户认证服务====================*/
    }

    /**
     * 用来配置Filter链
     * @param web Sspring Web Security对象
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /**
     * 用来配置拦截保护的请求，比如什么请求放行，什么请求响应验证
     * @param http http安全请求 对象
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()//开启登录配置
//                .antMatchers("/user/welcome","/user/details").hasAnyRole("USER","ADMIN")//表示访问 /hello 这个接口，需要具备 admin 这个角色
//                .antMatchers("/ADMIN/**").hasAnyAuthority("ROLE_ADMIN")
//                .anyRequest().authenticated()//表示剩余的其他接口，登录之后就能访问
//                .and()
//                .formLogin()//formLogin代表使用Spring Security默认的登录界面
////                //定义登录页面，未登录时，访问一个需要登录之后才能访问的接口，会自动跳转到该页面
////                .loginPage("/login")
////                //登录处理接口
////                .loginProcessingUrl("/doLogin")
////                //定义登录时，用户名的 key，默认为 username
////                .usernameParameter("username")
////                //定义登录时，用户密码的 key，默认为 password
////                .passwordParameter("password")
//                //登录成功的处理器
//                .successHandler(new AuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
//                        resp.setContentType("application/json;charset=utf-8");
//                        PrintWriter out = resp.getWriter();
//                        out.write("success");
//                        out.flush();
//                    }
//                })
//                .failureHandler(new AuthenticationFailureHandler() {
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
//                        resp.setContentType("application/json;charset=utf-8");
//                        PrintWriter out = resp.getWriter();
//                        out.write("fail");
//                        out.flush();
//                    }
//                })
//                .permitAll()//和表单登录相关的接口统统都直接通过
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessHandler(new LogoutSuccessHandler() {
//                    @Override
//                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
//                        resp.setContentType("application/json;charset=utf-8");
//                        PrintWriter out = resp.getWriter();
//                        out.write("logout success");
//                        out.flush();
//                    }
//                })
//                .permitAll()
//                .and()
//                .httpBasic()//httpBasic方法说明启用HTTP基础认证
//                .and()
//                .csrf().disable();


//         // 限定签名后的权限
//         http.
//         /* ########第一段######## */
//         authorizeRequests()
//         // 限定"/user/welcome"请求赋予角色ROLE_USER或者ROLE_ADMIN
//         .antMatchers("/user/welcome", "/user/details").hasAnyRole("USER", "ADMIN")
//         // 限定"/admin/"下所有请求权限赋予角色ROLE_ADMIN
//         .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
//         // 其他路径允许签名后访问
//         .anyRequest().permitAll()
//
//         /* ######## 第二段 ######## */
//         /** and代表连接词 **/
//         // 对于没有配置权限的其他请求允许匿名访问
//         .and().anonymous()
//
//         /* ######## 第三段 ######## */
//         // 使用Spring Security默认的登录页面
//         .and().formLogin()
//         // 启动HTTP基础验证
//         .and().httpBasic();


//        http./*csrf().disable().*/authorizeRequests()
//		// 使用Spring表达式限定只有角色ROLE_USER或者ROLE_ADMIN
//		.antMatchers("/user/**").access("hasRole('USER') or hasRole('ADMIN')")
//		 // 设置访问权限给角色ROLE_ADMIN，要求是完整登录(非记住我登录)
//		.antMatchers("/admin/welcome1").
//		    access("hasAuthority('ROLE_ADMIN') && isFullyAuthenticated()")
//	    // 限定"/admin/welcome2"访问权限给角色ROLE_ADMIN，允许不完整登录
//		.antMatchers("/admin/welcome2").access("hasAuthority('ROLE_ADMIN')")
//		// 使用Spring Security默认的登录页面
//		.and().formLogin()
//		// 启动HTTP基础验证
//		.and().httpBasic();

        http
        // 访问/admin下的请求需要管理员权限
        .authorizeRequests().antMatchers("/admin/**").access("hasRole('ADMIN')")
        //启用remember me功能
        .and().rememberMe().tokenValiditySeconds(86400).key("remember-me-key")
        // 启动HTTP基础验证
		.and().httpBasic().realmName("my-basic-name")
        // 通过签名后可以访问任何请求
        .and().authorizeRequests()
        .antMatchers("/**").permitAll()
        // 设置登录页和默认的跳转路径
        .and().formLogin().loginPage("/login/page")
        .defaultSuccessUrl("/admin/welcome1")
        // 登出页面和默认跳转路径
        .and().logout().logoutUrl("/logout/page")
        .logoutSuccessUrl("/welcome");

    }
}
