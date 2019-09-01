package com.e.doe.manager.donatedItem;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.e.doe.manager.utils.PrivilegeUtils;
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
	@PreAuthorize("hasAuthority('" + PrivilegeUtils.PRIVILAGE_USER + "')")
	public List<DonatedItem> getDonatedItems(){
		
		LOGGER.info("get DonatedItems");

		return this.donatedItemService.getDonatedItems();
		
	}
	
	@ApiOperation(value="Get a Donated Item by Id")
	@GetMapping({"/findById"})
	@PreAuthorize("hasAuthority('" + PrivilegeUtils.PRIVILAGE_USER + "')")
	public DonatedItem getDonatedItem(@RequestParam("id") String idDonation){
		
		LOGGER.info("get item by id: " + idDonation);

		return this.donatedItemService.getDonatedItem(idDonation);
	}
	
	@ApiOperation(value="Get Donated Itens by Description")
	@GetMapping({"/findByDescription"})
	@PreAuthorize("hasAuthority('" + PrivilegeUtils.PRIVILAGE_USER + "')")
	public List<DonatedItem> getDonatedItens(@RequestParam("description") String description){
		
		LOGGER.info("get itens by description: " + description);

		return this.donatedItemService.getDonatedItemByDescription(description);
	}
	
	@ApiOperation(value="Create a Donated Item")
	@PostMapping({"/", ""})
	@PreAuthorize("hasAuthority('" + PrivilegeUtils.PRIVILAGE_USER + "')")
	public DonatedItem postDonatedItem(@RequestBody @Valid DonatedItem item) {
		
		LOGGER.info("trying create Donated Item");

		DonatedItem donatedItem = this.donatedItemService.postDonatedItem(item);
		
		LOGGER.info("Donated Item created");

		return donatedItem;
		
	}

	@ApiOperation(value="Delete a Donated Item")
	@DeleteMapping({"/{id}/", "/{id}"})
	@PreAuthorize("hasAuthority('" + PrivilegeUtils.PRIVILAGE_ADMIN + "')")
	public ResponseEntity<?> deleteDonatedItem(@PathVariable(value="id") String id) {
		
		LOGGER.info("trying delete Donated Item: " + id);

		this.donatedItemService.deleteDonatedItem(id);
		
		LOGGER.info("Donated Item " + id + " deleted");

		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value="Update a Donated Item")
	@PutMapping({"/{id}/", "/{id}"})
	@PreAuthorize("hasAuthority('" + PrivilegeUtils.PRIVILAGE_ADMIN + "')")
	public DonatedItem updateDonatedItem(@PathVariable(value="id") String id, @RequestBody @Valid DonatedItem item) {
		
		LOGGER.info("trying update Donated Item: " + id);

		DonatedItem donatedItem = this.donatedItemService.updateDonatedItem(id, item); 
		
		LOGGER.info("Donated Item " + id + " update");

		return donatedItem;
		
	}
	

}
