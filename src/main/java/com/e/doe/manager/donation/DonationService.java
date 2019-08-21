package com.e.doe.manager.donation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.doe.manager.user.User;
import com.e.doe.manager.user.UserRepository;

@Service
public class DonationService {

	@Autowired
	private DonationRepository donationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public String getDonations(){
		List<Donation> donationsList = donationRepository.findAll();
		
		String donations = "";
		
		if (donationsList.size() > 0) {
			for(int i= 0; i < donationsList.size() - 1; i++) {
				donations += donationsList.get(i).toString()
						+ ", " + this.getUserIdentification(donationsList.get(i).getIdDonation()) 
						+ ", " + this.getUserIdentification(donationsList.get(i).getIdReceptor()) 
						+ " |\n";
			}
		
			int lastItem = donationsList.size() - 1;
			donations += donationsList.get(lastItem).toString() + ", " + this.getUserIdentification(donationsList.get(lastItem).getIdDonation());
		}
		return donations;
	}
	
	public String getDonation(long id){
		return donationRepository.findById(id).toString();
	}
	
	public String postDonation(Donation donation) {
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
}
