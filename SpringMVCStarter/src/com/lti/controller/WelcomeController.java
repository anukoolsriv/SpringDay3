package com.lti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping(path="welcome.do")
	public String welcome(){
		System.out.println("----welcome---");
		return "welcome.jsp";
	}
}
