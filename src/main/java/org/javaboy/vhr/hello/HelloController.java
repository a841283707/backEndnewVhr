package org.javaboy.vhr.hello;

import org.javaboy.vhr.bean.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    /*@GetMapping("/login")
    public String hello(){
        return
    }*/
    @GetMapping("/login")
    public RespBean respBean(){
        return RespBean.error("未登录");
    }

}
