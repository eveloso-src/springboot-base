package com.foo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;

@RestController
public class HelloController {
	
	Log log = LogFactory.getLog(HelloController.class);

	@RequestMapping("/")
	public String index() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.info("usuario: " + auth.getPrincipal());
		log.info("credentials: " + auth.getCredentials());
		log.info("authorities: " + auth.getAuthorities()) ;
		log.info("details : " + auth.getDetails());	
		return "Greetings from Spring Boot!";
	}
}
