package com.sezayir.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sezayir.conference.model.Registration;

@Controller
public class RegistrationController {

	@RequestMapping("/registration")
	public String getRegisteration(@ModelAttribute("registerAtr") Registration registration) {
		System.out.println("getRegisteration:" + "name=" + registration.getName());
		return "registration";
	}

	@PostMapping("/registration")
	public String addRegisteration(@ModelAttribute("registerAtr") Registration registration) {
		System.out.println("addRegisteration:" + "name=" + registration.getName());
		return "registration";
	}

}
