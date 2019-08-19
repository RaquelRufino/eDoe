package com.e.doe.manager.donation;


import java.util.List;

import javax.validation.Valid;

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
	
	@Autowired
	public DonationController(DonationService donationService) {
		this.donationService = donationService;
	}
	
	@ApiOperation(value = "Get All Donations")
	@GetMapping({"/", ""})
	public List<Donation> getDonations(){
		return donationService.getDonations();
	}
	
	@ApiOperation(value = "Get a Donation")
	@GetMapping({"/{id}/", "/{id}"})
	public Donation getDonation(@PathVariable(value="id") long id){
		return donationService.getDonation(id);
	}
	
	@ApiOperation(value="Create a Donation")
	@PostMapping({"/", ""})
	public Donation postDonation(@RequestBody @Valid Donation donation) {
		return donationService.postDonation(donation);
	}

	@ApiOperation(value="Delete a donation")
	@DeleteMapping({"/{id}/", "/{id}"})
	public ResponseEntity<?> deleteDonation(@PathVariable(value="id") long id) {
		
		donationService.deleteDonation(id);
		return ResponseEntity.ok().build();

	}
	
	@ApiOperation(value="Update a donation")
	@PutMapping({"/{id}/", "/{id}"})
	public Donation updateDonation(@RequestBody @Valid Donation donation) {
		return donationService.updateDonation(donation);
	}
}
