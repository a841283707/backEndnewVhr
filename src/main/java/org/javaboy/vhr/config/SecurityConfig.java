package org.javaboy.vhr.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.javaboy.vhr.bean.Hr;
import org.javaboy.vhr.bean.RespBean;
import org.javaboy.vhr.services.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    HrService hrService;

    @Autowired
    CustomerAccessDecisionManage customerAccessDecisionManage;

    @Autowired
    CustomerFilter customerFilter;
    //密码的编码器
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //利用configure方法把hrService配置进去

    //身份验证管理构造器传入service，使得输入账号密码后可以登录
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //验证请求
        http.authorizeRequests()
                /*//所有的请求都需要验证
                .anyRequest().authenticated()*/
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(customerAccessDecisionManage);
                        object.setSecurityMetadataSource(customerFilter);
                        return object;
                    }
                })
                .and()
                .formLogin()
                    .usernameParameter("username")
                    .passwordParameter("password")
                    //处理登录post请求的接口由系统实现
                    .loginProcessingUrl("/doLogin")
                    //未登录跳转的url
                    .loginPage("/login")
                    .successHandler(new AuthenticationSuccessHandler() {
                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                            //设置resp的返回类型为json类型
                            resp.setContentType("application/json;charset=utf-8");
                            //获取打印机并且向文本输出流打印对象的格式化表示形式。
                            PrintWriter out=resp.getWriter();
                            //获取需要转化的对象
                            Hr hr=(Hr)authentication.getPrincipal();
                            hr.setPassword(null);
                            RespBean respBean=RespBean.ok("登录成功",hr);
                            //把对象转成string
                            String s=new ObjectMapper().writeValueAsString(respBean);
                            out.write(s);
                            //清空关闭out
                            out.flush();
                            out.close();

                        }
                    })
                    .failureHandler(new AuthenticationFailureHandler() {
                        @Override
                        public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {

                            //设置resp的返回类型为json类型
                            resp.setContentType("application/json;charset=utf-8");
                            //向文本输出流打印对象的格式化表示形式。
                            PrintWriter out=resp.getWriter();
                            //获取对象的json字符串
                            RespBean respBean=RespBean.error("登录错误");
                            if (e instanceof LockedException){
                                respBean.setMsg("账户被锁定");
                            }else if (e instanceof CredentialsExpiredException){
                                respBean.setMsg("密码已过期");
                            }else if (e instanceof AccountExpiredException){
                                respBean.setMsg("账户已过期");
                            }else if (e instanceof DisabledException){
                                respBean.setMsg("账户已禁用");
                            }else if (e instanceof BadCredentialsException){
                                respBean.setStatus(500);
                                respBean.setMsg("账户或者密码错误");
                            }
                            out.write(new ObjectMapper().writeValueAsString(respBean));
                            //清空关闭out
                            out.flush();
                            out.close();
                        }
                    })
                    .permitAll()
                .and()
                .logout()
                    .logoutUrl("/doLogout")
                    //注销成功处理器
                    .logoutSuccessHandler(new LogoutSuccessHandler() {
                        @Override
                        public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {
                            resp.setContentType("application/json;charset=utf-8");
                            PrintWriter printWriter=resp.getWriter();
                            RespBean.ok("注销登录成功");
                            printWriter.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销登录成功")));
                        }
                    })
                    .permitAll()
                .and()
                .csrf().disable()
                //在身份验证入口出现异常处理办法,避免出现重定向到Login而出现的跨域问题
                //可以resp在客户端redict，也可以req在服务端dispatch，也可以直接返回json
                .exceptionHandling()
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
                        //设置resp的返回类型为json类型
                        resp.setContentType("application/json;charset=utf-8");
                        //向文本输出流打印对象的格式化表示形式。
                        PrintWriter out=resp.getWriter();
                        //获取对象的json字符串
                        RespBean respBean=RespBean.error("登录错误");
                        //不充足的身份验证异常
                        if (e instanceof InsufficientAuthenticationException){
                            respBean.setMsg("先登录");
                        }
                        out.write(new ObjectMapper().writeValueAsString(respBean));
                        //清空关闭out
                        out.flush();
                        out.close();

                    }
                });
    }
}
