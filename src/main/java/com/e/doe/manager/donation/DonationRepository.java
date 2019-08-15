package com.e.doe.manager.donation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("donationRepository")
public interface DonationRepository extends JpaRepository<Donation, Long> {

	Donation findById(long id);
}
