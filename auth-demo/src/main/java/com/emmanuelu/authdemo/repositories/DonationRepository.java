package com.emmanuelu.authdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emmanuelu.authdemo.models.Donation;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long> {
	List<Donation> findAll(); //find all donations
}
