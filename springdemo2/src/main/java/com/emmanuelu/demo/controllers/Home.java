package com.emmanuelu.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home {
	
	@RequestMapping("/")
	public String index() {
		return "demo.jsp";
	}
	
	@RequestMapping("/test")
	public String displayJstl() {
		return "jstl.jsp";
	}

}
