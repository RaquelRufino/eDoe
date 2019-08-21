package com.e.doe.manager.donation;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e.doe.manager.utils.RestConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = RestConstants.DONATION_URI)
@Api(tags = "Donation")
public class DonationController {
	
	
	private DonationService donationService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	public DonationController(DonationService donationService) {
		
		this.donationService = donationService;
	}
	
	@ApiOperation(value = "Get All Donations")
	@GetMapping({"/", ""})
	public String getDonations(){
		
		LOGGER.info("get Donations");

		return donationService.getDonations();
	}
	
	@ApiOperation(value = "Get a Donation")
	@GetMapping({"/{id}/", "/{id}"})
	public String getDonation(@PathVariable(value="id") long id){
		
		LOGGER.info("get donation: " + id);

		return donationService.getDonation(id);
	}
	
	@ApiOperation(value="Create a Donation")
	@PostMapping({"/", ""})
	public String postDonation(@RequestBody @Valid Donation donation) {
		
		LOGGER.info("trying create donation");
		
		String newDonation = donationService.postDonation(donation);
		
		LOGGER.info("Donation created");
		
		return newDonation;
	}

	@ApiOperation(value="Delete a donation")
	@DeleteMapping({"/{id}/", "/{id}"})
	public ResponseEntity<?> deleteDonation(@PathVariable(value="id") long id) {
		
		LOGGER.info("trying delete Donation: " + id);

		donationService.deleteDonation(id);
		
		LOGGER.info("Donation " + id + " deleted");

		return ResponseEntity.ok().build();

	}
	
	@ApiOperation(value="Update a donation")
	@PutMapping({"/{id}/", "/{id}"})
	public String updateDonation(@RequestBody @Valid Donation donation, @PathVariable(value="id") long id) {
		
		LOGGER.info("trying update Donation: " + id);
		
		String donationUpdate = donationService.updateDonation(donation, id);
		
		LOGGER.info("Donation " + id + " update");

		return donationUpdate;
	}
}
