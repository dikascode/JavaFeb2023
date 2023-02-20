package com.emmanuelu.authdemo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.emmanuelu.authdemo.models.Donation;
import com.emmanuelu.authdemo.services.DonationService;

@Controller
public class HomeController {

	@Autowired
	private DonationService donationService;
	
	// Display donation form
	@GetMapping("/donations/new")
	public String showDonationForm(Model model, HttpSession session) {
		
		model.addAttribute("newDonation", new Donation());
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/home";
		}

		return "newDonation.jsp";
	}
	
	
	// process donation submission
	@PostMapping("/donations/new")
	public String processDonationForm(@Valid @ModelAttribute("newDonation") Donation donation, BindingResult result,
			Model model, HttpSession session) {
		if (result.hasErrors()) {
			return "newDonation.jsp";
		} else {
			donationService.createDonation(donation);
			return "redirect:/home";
		}

	}




}
