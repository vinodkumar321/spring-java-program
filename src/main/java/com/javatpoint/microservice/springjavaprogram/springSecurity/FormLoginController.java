package com.javatpoint.microservice.springjavaprogram.springSecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
public class FormLoginController {

    @GetMapping("/public/greetMessage")
    public String greetMessageUser(){
        return "Hello Vinod Kumar, logged in as User Role,No Authentication Required";
    }

    @GetMapping("/admin/greetMessage")
    public String greetMessageAdmin(){
        return "Hello Vinod Kumar, logged in as User ADMIN,Authentication Required";
    }

}
