package com.emmanuelu.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FruitController {
	
	@RequestMapping("/fruit")
	public String returnFruit(Model model) {
		String hackerScript = "<script>alert('Hacked!')</script>";
		model.addAttribute("fruit1", "Apple");
		model.addAttribute("fruit2", "Melon");
		model.addAttribute("hacker", hackerScript);
		return "jstl.jsp";
	}

}
