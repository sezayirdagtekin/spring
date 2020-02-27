package com.sezayir.conference.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {
	
	
	   @RequestMapping("/registration")
	    public String home(Map<String, Object> model) {
	        model.put("message", "Welcome to regsitratiom !!!");
	        return "registration";
	    }

}
