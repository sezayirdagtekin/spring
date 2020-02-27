package com.sezayir.conference.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class ConferenceConfig implements WebMvcConfigurer {

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    //You can acces from
		//http://localhost:8080/conference/pdf/ps.pdf 
		registry.addResourceHandler("/files/**").addResourceLocations("WEB-INF/pdf/");
	}

	@Bean
	public ViewResolver viewResolver() {
		System.out.println("ViewResolver...");
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/view/");
		bean.setSuffix(".jsp");
		bean.setOrder(0);
		return bean;
	}

}
