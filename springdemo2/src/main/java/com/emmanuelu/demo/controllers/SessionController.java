package com.emmanuelu.demo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sessions")
public class SessionController {
	
@GetMapping("/home")
public String index(HttpSession session) {
		
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
		// increment the count by 1 using getAttribute and setAttribute
			Integer conta = (Integer) session.getAttribute("count");
			session.setAttribute("count", conta+1);
		}
		return "/sessions/home.jsp";
	}


@GetMapping("/getcount")
public String getCount(HttpSession session, Model model) {
	Integer conta = (Integer) session.getAttribute("count");
	model.addAttribute("count", conta);
	return "/sessions/getCount.jsp";
}

	
}
