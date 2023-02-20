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

	// Find All
	public List<Donation> findAllDonations() {
		return donationRepo.findAll();
	}

}
