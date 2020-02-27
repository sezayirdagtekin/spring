package com.sezayir.conference;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConferenceController {
	
	
	   @RequestMapping("/")
	    public String home(Map<String, Object> model) {
	        model.put("message", "Welcome to mainpage !!!");
	        return "welcome";
	    }
	   
	@GetMapping("/hello")
	public String sayHello(Map<String,Object> model) {
		
	    model.put("message", "Hello Mvc");

		return "hello";
		
	}

}
