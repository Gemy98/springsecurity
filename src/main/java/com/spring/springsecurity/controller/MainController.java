package com.spring.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/")
// http://localhost:8080/api/
public class MainController {


    // http://localhost:8080/api/main
    @GetMapping("main")
    public String index(){
        return "index";
    }


    // http://localhost:8080/api/fr
    @GetMapping("fr")
    public String fr(){
        return "fragments";
    }


    // http://localhost:8080/api/profile
    @GetMapping("/profile")
    public String profile(){
        return "profile/index";
    }


    // http://localhost:8080/api/manage
    @GetMapping("manage")
    public String manage(){
        return "management/index";
    }



    // http://localhost:8080/api/admin
    @GetMapping("admin")
    public String admin(){
        return "admin/index";
    }


    // http://localhost:8080/api/admin/myadmin
    @GetMapping("admin/myadmin")
    public String myadmin(){
        return "admin/myadmin";
    }

}
