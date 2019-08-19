package com.e.doe.manager.donatedItem;

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
@RequestMapping(value = RestConstants.DONATED_ITEM_URI)
@Api(tags = "donatedItem")
public class DonatedItemController {
	
	private DonatedItemService donatedItemService;

	@Autowired
	public DonatedItemController(DonatedItemService donatedItemService) {
		this.donatedItemService = donatedItemService;
	}

	@ApiOperation(value="Get All donated item")
	@GetMapping({"/", ""})
	public String getDonatedItems(){
		
		String Items = this.donatedItemService.getDonatedItems();
		return Items;
		
	}
	
	@ApiOperation(value="Get a Donated Item")
	@GetMapping({"/{id}/", "/{id}"})
	public String getDonatedItem(@PathVariable(value="id") long id){
			
		return this.donatedItemService.getDonatedItem(id);
	}
	
	
	@ApiOperation(value="Create a Donated Item")
	@PostMapping({"/", ""})
	public DonatedItem postDonatedItem(@RequestBody @Valid DonatedItem item) {
		
		return this.donatedItemService.postDonatedItem(item);
		
	}

	@ApiOperation(value="Delete a Donated Item")
	@DeleteMapping({"/{id}/", "/{id}"})
	public ResponseEntity<?> deleteDonatedItem(@PathVariable(value="id") long id) {
		this.donatedItemService.deleteDonatedItem(id);
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value="Update a Donated Item")
	@PutMapping({"/{id}/", "/{id}"})
	public DonatedItem updateDonatedItem(@PathVariable(value="id") long id, @RequestBody @Valid DonatedItem item) {
		
		return this.donatedItemService.updateDonatedItem(id, item);

	}
	

}
