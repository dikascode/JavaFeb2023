package com.emmanuelu.authdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emmanuelu.authdemo.models.Donation;
import com.emmanuelu.authdemo.repositories.DonationRepository;

@Service
public class DonationService {

	@Autowired
	private DonationRepository donationRepo;

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

}
