package com.sezayir.conference.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sezayir.conference.model.User;

@RestController
public class UserController {

	@GetMapping("/user")
	public User getUser(@RequestParam(value = "firstname", defaultValue = "sezayir") String firstname,
			@RequestParam(value = "lastname", defaultValue = "Dagtekin") String lastname,
			@RequestParam(value = "age", defaultValue = "38") int age) {

				User user = new User();
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setAge(age);
				
		return user;
	}
	
	@PostMapping("adduser")
	public User addUser(User user) {
		System.out.println("User:"+user.toString());
		return user;
	}

}
