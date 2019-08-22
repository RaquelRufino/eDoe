package com.e.doe.manager.donation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.doe.manager.donatedItem.DonatedItem;
import com.e.doe.manager.donatedItem.DonatedItemRepository;
import com.e.doe.manager.user.User;
import com.e.doe.manager.user.UserRepository;

@Service
public class DonationService {

	@Autowired
	private DonationRepository donationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DonatedItemRepository donatedItemRepository;
	
	public String getDonations(){
		List<Donation> donationsList = donationRepository.findAll();
		
		return donationsList.stream()
	      .sorted(Comparator.comparing(Donation::getDate).thenComparing(Donation::getDescription))
	      .map(Donation::toString)
	      .collect(Collectors.joining(" | "));
	}
	
	public String getDonation(long id){
		return donationRepository.findById(id).toString();
	}
	
	public String postDonation(Donation donation) {
		
		DonatedItem itemDona = donatedItemRepository.findByDescriptionAndIdDonation(donation.getDescription(), donation.getIdDonation());
		
		int donationAmount = getDonationAmount(itemDona.getAmount(), donation.getAmount());
		
		itemDona.setAmount(itemDona.getAmount() - donationAmount );
		
		return donationRepository.save(donation).toString();
	}
	
	public void deleteDonation(long id) {
		Donation donation =  this.donationRepository.findById(id);
		donationRepository.delete(donation);
	}
	
	public String updateDonation(Donation donation, long id) {
		
		//TODO
		return donationRepository.save(donation).toString();
	}
	
	public String getUserIdentification(String idDonation) {
		User user = userRepository.findById(idDonation);
	    return user.getStatus() + ": " + user.geidentification();
	}
	
	private int getDonationAmount(int itemNec, int donatedItem) {
	    return donatedItem - itemNec >= 0 ? itemNec : donatedItem;
	 }
}
