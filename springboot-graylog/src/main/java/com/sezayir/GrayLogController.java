package com.sezayir;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrayLogController {
	private static final String greeting="hello";
	
	@GetMapping("/greeting")
	public  String sayHello() {
		
		Logger logger= Logger.getLogger(GrayLogController.class);
		logger.debug("heyyy....");
		logger.debug("there....");
		logger.debug("how are you?");
		
		return  greeting;
		
		
	}

}
