package com.emmanuelu.demo.form2;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/forms")
public class SearchController {
	
	//Using GET we need two methods
	
	//Display our form
	@GetMapping("/showform")
	public String displayForm() {
		return "/form/search.jsp";
	}
	
	
	//Process our form
	@GetMapping("/result")
	public String processForm(
			 @RequestParam(value="search") String searchTerm,
			 Model model
			) {
		model.addAttribute("searchTerm", searchTerm);
		return "/form/getResult.jsp";
	}
	
	
	
	//POST process
	//Display the form
	@GetMapping("/displayPost")
	public String displayPostForm() {
		return "/form/postForm.jsp";
	}
	
	
	//Process the form
	@PostMapping("/post")
	public String processPostForm(
			@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,
			Model model,
			HttpSession session,
			RedirectAttributes redirectAttributes
			) {
		
		if(password.length() > 4) {
			session.setAttribute("email", email);
			System.out.println(email);
		} else {
			redirectAttributes.addFlashAttribute("error", "Your password is too short");
			session.setAttribute("email", "johndoe@nosuer.com");
		}
		
		//Redirect after processing your form
		
		return "redirect:/forms/postResult";
	}
	
	
	//Display result after submitting form
	@GetMapping("/postResult")
	public String showPostResult(HttpSession session, Model model) {
//		String email = (String) ;
		model.addAttribute("email1", session.getAttribute("email"));
		return "/form/postResult.jsp";
	}
	

}
