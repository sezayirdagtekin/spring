package com.sezayir.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class UserController {
    @GetMapping("/greeting")
    public String say() {
        return "Hi There!";
    }
}