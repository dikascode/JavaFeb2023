package com.emmanuelu.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NinjaController {
	
	@RequestMapping("/ninjas")
	public String displayDojoNinjas(Model model) {
		   ArrayList<String> dojos = new ArrayList<String>();
	        dojos.add("Burbank");
	        dojos.add("Chicago");
	        dojos.add("Bellevue");
	        dojos.add("Lagos");
	        dojos.add("Mars");
	        model.addAttribute("ninjasFromMyController", dojos);
		return "ninja.jsp";
	}
}
