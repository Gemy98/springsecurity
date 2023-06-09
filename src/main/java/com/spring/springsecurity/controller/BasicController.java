package com.spring.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/basic/")
public class BasicController {


    // http://localhost:8080/api/basic/mybasic
    @GetMapping("/mybasic")
    public String login(){

        return "my name is eslam";
    }


    // http://localhost:8080/api/basic/allbasic
    @GetMapping("/allbasic")
    public String all(){
        return "i am here";
    }

}
