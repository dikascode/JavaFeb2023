package com.emmanuelu.demo.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormDemo {
	//Showing form
	@RequestMapping("/login")
	public String showForm() {
		return "form.jsp";
	}
	
	//Processing form
	//Showing form
	@RequestMapping("/showResult")
	public String processForm(
			@RequestParam(value="email") String email,
		    @RequestParam(value="password") String password)  {
		System.out.print(email);
		return "result.jsp";
	}

}
