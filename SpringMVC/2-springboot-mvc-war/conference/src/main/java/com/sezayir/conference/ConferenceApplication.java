package com.sezayir.conference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ConferenceApplication  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ConferenceApplication.class, args);
	}
	
    @Override
    protected SpringApplicationBuilder configure(
      SpringApplicationBuilder builder) {
        return builder.sources(ConferenceApplication.class);
    }
 

}

