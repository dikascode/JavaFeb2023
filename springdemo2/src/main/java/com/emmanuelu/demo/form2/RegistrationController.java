package com.emmanuelu.demo.form2;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("register")
public class RegistrationController {
	
	//Display Registration form
	@GetMapping("/home")
	public String registerUser() {
		return "/form/register.jsp";
	}
	
	
	//Process the form
	@PostMapping("registerForm")
	public String processForm(
			@RequestParam(value="courseID") String courseID,
			@RequestParam(value="name") String name3,
			@RequestParam(value="email") String email,
			@RequestParam(value="regDate") @DateTimeFormat(pattern ="yyyy-MM-dd") Date regDate,
			@RequestParam(value="regTime") @DateTimeFormat(pattern ="HH:mm") Date regTime,
			HttpSession session
			) {
		
		//Using @DateTimeFormat to format date and time
		//@RequestParam(value="regTime") @DateTimeFormat(pattern ="HH:mm") Date regTime
		
		
		session.setAttribute("courseID", courseID);
		session.setAttribute("name", name3);
		session.setAttribute("email", email);
		session.setAttribute("regDate", regDate);
		session.setAttribute("regTime", regTime);
		
		
		return "redirect:/register/showRegForm";
	}
	
	
	
	
	//Display result after submission
	@GetMapping("/showRegForm")
	public String showRegistrationForm() {
		return "/form/displayRegForm.jsp";
		
	}

}
