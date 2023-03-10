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

	// Edit Donation
	// Get method to show our edit form
	@GetMapping("/donations/edit/{id}")
	public String ShowEditDonationForm(@PathVariable("id") Long id, Model model, HttpSession session) {
		Donation donation = donationService.findOneDonation(id);
		model.addAttribute("donation", donation);

		if (donation.getDonor().getId() != (Long) session.getAttribute("userId")) {
			return "redirect:/home";
		}

		return "editDonation.jsp";

	}

	// process donation edit form using data binding
	@PutMapping("/donations/edit/{id}")
	public String editBook(@Valid @ModelAttribute("donation") Donation donation, BindingResult result) {

		if (result.hasErrors()) {
			return "editDonation.jsp";
		} else {
			donationService.editDonation(donation);
			return "redirect:/home";
		}

	}

	// Show One donation
	@GetMapping("/donations/{id}")
	public String showDonation(@PathVariable("id") Long id, Model model) {
		Donation donation = donationService.findOneDonation(id);
		model.addAttribute("donation", donation);
		return "oneDonation.jsp";
	}

	// Delete a donation and redirect to dash board
	@DeleteMapping("donations/delete/{id}")
	public String deleteDonatuion(@PathVariable("id") Long id) {
		donationService.deleteDonation(id);
		return "redirect:/home";
	}

	// Receive an Item
	@PutMapping("/donations/receive/{id}")
	public String receiveDonation(@PathVariable("id") Long donationId, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		donationService.receiveDonation(donationId, userId);
		return "redirect:/home";
		
	}

	
	
	// Return an Item
	@PutMapping("/donations/return/{id}")
	public String returnDonation(@PathVariable("id") Long donationId, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		donationService.returnDonation(donationId, userId);
		return "redirect:/home";
		
	}


}
