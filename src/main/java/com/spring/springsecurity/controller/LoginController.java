package com.spring.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/")
// http://localhost:8080/api/
public class LoginController {

   // http://localhost:8080/api/login
    @GetMapping("/login")
    public String login(){

        return "login";
    }



}
