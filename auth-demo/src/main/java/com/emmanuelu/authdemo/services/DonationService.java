package com.emmanuelu.authdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuelu.authdemo.models.Donation;
import com.emmanuelu.authdemo.models.User;
import com.emmanuelu.authdemo.repositories.DonationRepository;

@Service
public class DonationService {

	@Autowired
	private DonationRepository donationRepo;

	@Autowired
	private UserService userService;

	// Create
	public Donation createDonation(Donation donation) {
		return donationRepo.save(donation);

	}

	// Edit
	public Donation editDonation(Donation donation) {
		return donationRepo.save(donation);

	}

	// Find All
	public List<Donation> findAllDonations() {
		return donationRepo.findAll();
	}

	// Find one
	public Donation findOneDonation(Long id) {
		Optional<Donation> optionalDonation = donationRepo.findById(id);

		if (optionalDonation.isPresent()) {
			return optionalDonation.get();
		} else {
			return null;
		}
	}

	// Delete
	public void deleteDonation(Long id) {
		donationRepo.deleteById(id);
	}

	// Receive a donation
	public void receiveDonation(Long donationId, Long userId) {
		//retrieve a donation
		Donation donation = this.findOneDonation(donationId);
		
		
		//retrieve a user
		User user = userService.findUser(userId);
		
		donation.getReceivers().add(user);
		donation.setQuantity(donation.getQuantity() -1);
		donationRepo.save(donation);
	}

	
	
	// Return a donation
	public void returnDonation(Long donationId, Long userId) {
		Donation donation = this.findOneDonation(donationId);
		User user = userService.findUser(userId);
		donation.getReceivers().remove(user);
		donation.setQuantity(donation.getQuantity() + 1);
		donationRepo.save(donation);

	}


}
