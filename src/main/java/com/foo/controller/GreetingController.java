package com.foo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	Log log = LogFactory.getLog(GreetingController.class);

	// REDIRECT
	@RequestMapping("/logon")
	public String logon(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		SimpleGrantedAuthority simple = new SimpleGrantedAuthority("USER"); // ROLE1

		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

		list.add(simple);
		list.addAll(auth.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), list));

		log.info("principal " + auth.getPrincipal());

		for (GrantedAuthority simpleGrantedAuthority : list) {

			log.info("simpleGrantedAuthority " + simpleGrantedAuthority.getAuthority());
		}

		return "index";
	}

	@RequestMapping(value = "/loginEvent", method = RequestMethod.POST)
	public String login2(@RequestParam(value = "username", required = false, defaultValue = "World") String user,
			@RequestParam(value = "password", required = false) String password, Model model) {
		model.addAttribute("user", user);


		log.info("user: " + user);


		return "login";
	}
	
	@RequestMapping(value = "/loginEvent", method = RequestMethod.GET)
	public String login(@RequestParam(value = "username", required = false, defaultValue = "World") String user,
			@RequestParam(value = "password", required = false) String password, Model model) {
		model.addAttribute("user", user);


		log.info("user: " + user);


		return "login";
	}

}