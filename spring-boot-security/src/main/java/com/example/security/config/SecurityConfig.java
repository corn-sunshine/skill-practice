package com.example.security.config;

import com.example.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.PrintWriter;

/**
 * @Description:
 * @Author: corn
 * @Date: 2021/11/11
 * @Version: 1.0
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    MyAuthenticationProvider myAuthenticationProvider() {
        MyAuthenticationProvider myAuthenticationProvider = new MyAuthenticationProvider();
        myAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        myAuthenticationProvider.setUserDetailsService(userDetailsService());
        return myAuthenticationProvider;
    }

    // 角色继承配置
    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
        // admin角色拥有user角色所有权限
        hierarchy.setHierarchy("ROLE_admin > ROLE_user");
        return hierarchy;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 在内存中定义多个用户
        /*auth.inMemoryAuthentication()
                .withUser("admin")
                .password("123456").roles("admin")
                .and()
                .withUser("corn")
                .password("123456").roles("user");*/
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring() // 配置忽略掉的 URL 地址，一般对于静态文件，我们可以采用此操作。
                .antMatchers("/js/**", "/css/**","/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/user/**").hasRole("user")
                .anyRequest().authenticated()
                .and()
                // 表单登录设置
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/doLogin")
//                .usernameParameter("") // 提交表单中用户、密码的属性不为username,password时，这里可以设置
//                .passwordParameter("")
                .defaultSuccessUrl("/index") /* 1、defaultSuccessUrl 有一个重载的方法，我们先说一个参数的 defaultSuccessUrl 方法。如果我们在
                                          defaultSuccessUrl 中指定登录成功的跳转页面为 /index，此时分两种情况，如果你是直接在浏览器中
                                          输入的登录地址，登录成功后，就直接跳转到 /index，如果你是在浏览器中输入了其他地址，
                                          例如 http://localhost:8080/hello，结果因为没有登录，又重定向到登录页面，此时登录成功后，
                                          就不会来到 /index ，而是来到 /hello 页面。
                                          2、defaultSuccessUrl 还有一个重载的方法，第二个参数如果不设置默认为 false，也就是我们上面的的情况，
                                          如果手动设置第二个参数为 true，则 defaultSuccessUrl 的效果和 successForwardUrl 一致。*/

//                .successForwardUrl("/index")
                                          /* successForwardUrl 表示不管你是从哪里来的，登录后一律跳转到 successForwardUrl 指定的地址。
                                          例如 successForwardUrl 指定的地址为 /index ，你在浏览器地址栏输入 http://localhost:8080/hello，
                                          结果因为没有登录，重定向到登录页面，当你登录成功之后，就会服务端跳转到 /index 页面；或者你直接就在浏览器输入了
                                          登录页面地址，登录成功后也是来到 /index。*/
                .permitAll() // 表示登录相关的页面/接口不要被拦截
                .and()
                // 退出登录配置
                .logout()
                .logoutUrl("/logout") // 默认注销的 URL 是 '/logout'，是一个 GET 请求，我们可以通过 logoutUrl 方法来修改默认的注销 URL
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST")) // logoutRequestMatcher 方法不仅可以修改注销 URL，还可以修改请求方式，实际项目中，这个方法和 logoutUrl 任意设置一个即可
                .logoutSuccessUrl("/index") // logoutSuccessUrl 表示注销成功后要跳转的页面
                .deleteCookies() // 用来清除 cookie
                .clearAuthentication(true) // 分别表示清除认证信息和使 HttpSession 失效，默认可以不用配置，默认就会清除。
                .invalidateHttpSession(true)
//                .logoutSuccessHandler((req, resp, authentication) -> {
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write("注销成功");
//                    out.flush();
//                    out.close();
//                })
                .permitAll()
                .and()// 表示结束当前标签，上下文回到HttpSecurity，开启新一轮的配置
                .csrf().disable()
                .exceptionHandling();
//                .authenticationEntryPoint((req, resp, authException) -> {
//                            resp.setContentType("application/json;charset=utf-8");
//                            PrintWriter out = resp.getWriter();
//                            out.write("尚未登录，请先登录");
//                            out.flush();
//                            out.close();
//                        }
//                );
    }
}
