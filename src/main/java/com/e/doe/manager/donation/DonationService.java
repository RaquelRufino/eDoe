package com.e.doe.manager.donation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DonationService {

	@Autowired
	private DonationRepository donationRepository;
	
	public List<Donation> getDonations(){
		return donationRepository.findAll();
	}
	
	public Donation getDonation(long id){
		return donationRepository.findById(id);
	}
	
	public Donation postDonation(Donation donation) {
		return donationRepository.save(donation);
	}
	
	public void deleteDonation(long id) {
		Donation donation =  this.donationRepository.findById(id);
		donationRepository.delete(donation);
	}
	
	public Donation updateDonation(Donation donation) {
		return donationRepository.save(donation);
	}
}
