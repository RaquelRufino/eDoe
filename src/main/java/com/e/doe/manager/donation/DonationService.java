package com.e.doe.manager.donation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.doe.manager.donatedItem.DonatedItem;
import com.e.doe.manager.donatedItem.DonatedItemRepository;
import com.e.doe.manager.requiredItem.RequiredItem;
import com.e.doe.manager.requiredItem.RequiredItemRepository;

@Service
public class DonationService {

	@Autowired
	private DonationRepository donationRepository;

	@Autowired
	private DonatedItemRepository donatedItemRepository;
	
	@Autowired
	private RequiredItemRepository requiredItemRepository;
	
	public List<Donation> getDonations(){
		List<Donation> donationsList = donationRepository.findAll();
		
		return donationsList;
	}
	
	public Donation getDonation(long id){
		return donationRepository.findById(id);
	}
	
	public Donation postDonation(Donation donation) {
		
		DonatedItem itemDona = donatedItemRepository.findByDescriptionAndIdDonation(donation.getDescription(), donation.getIdDonation());
		
		RequiredItem itemRequired = requiredItemRepository.findByDescriptionAndIdReceptor(donation.getDescription(), donation.getIdReceptor());

		int donationAmount = getDonationAmount(itemDona.getAmount(), donation.getAmount());
		
		itemDona.setAmount(itemDona.getAmount() - donationAmount );
		
		donatedItemRepository.save(itemDona);
		
		itemRequired.setAmount(itemRequired.getAmount() - donationAmount );
		
		requiredItemRepository.save(itemRequired);

		return donationRepository.save(donation);
	}
	
	public void deleteDonation(long id) {
		Donation donation =  this.donationRepository.findById(id);
		donationRepository.delete(donation);
	}
	
	public Donation updateDonation(Donation donation, long id) {
		
		//TODO
		return donationRepository.save(donation);
	}
	
	private int getDonationAmount(int itemNec, int donatedItem) {
	    return donatedItem - itemNec >= 0 ? itemNec : donatedItem;
	 }
}
