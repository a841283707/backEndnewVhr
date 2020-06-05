package org.javaboy.vhr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


/** 使swagger生效*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /** 获得docker实例*/
    @Bean
    public Docket docket(Environment environment){
        /** 获得profile___environment.acceptsProfiles,并且与定义的profiles比较，然后可以动态的开启swagger*/
        Profiles profiles=Profiles.of("dev");
        boolean b = environment.acceptsProfiles(profiles);


        /*传入Documentation*/
        ApiInfo apiInfo=new ApiInfo("微人事","用于学习的一个开源项目","1.0","https://blog.csdn.net/weixin_43532415", new Contact("沙漏里的时光", "https://blog.csdn.net/weixin_43532415", "949282760@qq.com"), "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
        /*传入一个DocumentationType，修改apiInfo*/
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                /*是否开启swagger*/
                .enable(b)
                .groupName("沙漏里的时光_微人事")
                .select()
                /*
                .withClassAnnotation（扫描指定注解的类）
                .withMethodAnnotation扫描指定注解的方法）
                指定扫描的包.basePackage*/
                .apis(RequestHandlerSelectors.basePackage("org.javaboy.vhr.controller"))
                /*扫描指定的格式的url*/

                //.paths(PathSelectors.ant(""))

                .build()
                ;
    }
}
