package com.e.doe.manager.donation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.doe.manager.donation.models.Donation;


@Repository("donationRepository")
public interface DonationRepository extends JpaRepository<Donation, Long> {

	Donation findById(long id);
}
