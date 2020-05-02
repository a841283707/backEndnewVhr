package org.javaboy.vhr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描mapper的包
@MapperScan(basePackages = "org.javaboy.vhr.mapper")
public class VhrhouduanApplication {

    public static void main(String[] args) {
        SpringApplication.run(VhrhouduanApplication.class, args);
    }

}
