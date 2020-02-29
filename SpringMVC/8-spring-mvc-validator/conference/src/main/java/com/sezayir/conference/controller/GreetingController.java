package com.sezayir.conference.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
	
	@GetMapping("/greeting")
	public String sayHello(Map<String,Object> model) {
		
	    model.put("message", "Hello Mvc");

		return "greeting";
		
	}

}
