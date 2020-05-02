package org.javaboy.vhr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class testController {
    @GetMapping("/employee/basic/sss")
    public String hello(){
        return "/emp/basic/sss";
    }

    @GetMapping("/personnel/emp/sss")
    public String cool(){
        return "/emp/basic/sss";
    }

    @GetMapping("/salary/sob/sss")
    public String hello1(){
        return "/emp/basic/sss";
    }

    @GetMapping("/statistics/score/sss")
    public String hello2(){
        return "/emp/basic/sss";
    }
}
