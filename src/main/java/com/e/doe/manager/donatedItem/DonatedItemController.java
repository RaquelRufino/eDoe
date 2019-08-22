package com.e.doe.manager.donatedItem;

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
@RequestMapping(value = RestConstants.DONATED_ITEM_URI)
@Api(tags = "donatedItem")
public class DonatedItemController {
	
	private DonatedItemService donatedItemService;
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public DonatedItemController(DonatedItemService donatedItemService) {
		this.donatedItemService = donatedItemService;
	}

	@ApiOperation(value="Get All donated item")
	@GetMapping({"/", ""})
	public String getDonatedItems(){
		
		LOGGER.info("get DonatedItems");

		return this.donatedItemService.getDonatedItems();
		
	}
	
	@ApiOperation(value="Get a Donated Item by Id")
	@GetMapping({"/id/{id}/", "/id/{id}"})
	public String getDonatedItem(@PathVariable(value="id") long id){
		
		LOGGER.info("get item by id: " + id);

		return this.donatedItemService.getDonatedItem(id);
	}
	
	@ApiOperation(value="Get Donated Itens by Description")
	@GetMapping({"/description/{description}/", "/description/{description}"})
	public String getDonatedItens(@PathVariable(value="description") String description){
		
		LOGGER.info("get itens by description: " + description);

		return this.donatedItemService.getDonatedItem(description);
	}
	
	@ApiOperation(value="Create a Donated Item")
	@PostMapping({"/", ""})
	public String postDonatedItem(@RequestBody @Valid DonatedItem item) {
		
		LOGGER.info("trying create Donated Item");

		String donatedItem = this.donatedItemService.postDonatedItem(item);
		
		LOGGER.info("Donated Item created");

		return donatedItem;
		
	}

	@ApiOperation(value="Delete a Donated Item")
	@DeleteMapping({"/{id}/", "/{id}"})
	public ResponseEntity<?> deleteDonatedItem(@PathVariable(value="id") long id) {
		
		LOGGER.info("trying delete Donated Item: " + id);

		this.donatedItemService.deleteDonatedItem(id);
		
		LOGGER.info("Donated Item " + id + " deleted");

		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value="Update a Donated Item")
	@PutMapping({"/{id}/", "/{id}"})
	public String updateDonatedItem(@PathVariable(value="id") long id, @RequestBody @Valid DonatedItem item) {
		
		LOGGER.info("trying update Donated Item: " + id);

		String donatedItem = this.donatedItemService.updateDonatedItem(id, item); 
		
		LOGGER.info("Donated Item " + id + " update");

		return donatedItem;
		
	}
	

}
