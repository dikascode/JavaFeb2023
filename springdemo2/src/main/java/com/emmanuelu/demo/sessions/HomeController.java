package com.emmanuelu.demo.sessions;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/session")
public class HomeController {
	
	@GetMapping("/home")
	public String index(HttpSession session) {
		//save a session
		if(session.getAttribute("conta") == null) {
			//set session
			session.setAttribute("conta", 0);
		}else {
			
			Integer conta = (Integer) session.getAttribute("conta");
			//update session
			session.setAttribute("conta", conta+1);
		}
	
		return "session2/sessionHome.jsp";
	}
	
	//Show our session representation
	@GetMapping("/getconta")
	public String showConta(HttpSession session, Model model) {
		Integer conta = (Integer) session.getAttribute("conta");
		model.addAttribute("conta", conta);
		
		return "session2/getConta.jsp";
		
	}

}
