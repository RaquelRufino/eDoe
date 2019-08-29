package com.e.doe.manager.requiredItem;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.e.doe.manager.donatedItem.DonatedItem;
import com.e.doe.manager.utils.RestConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = RestConstants.REQUIRED_ITEM_URI)
@Api(tags = "requiredItem")
public class RequiredItemController {
	
	private RequiredItemService requiredItemService;
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public RequiredItemController(RequiredItemService requiredItemService) {
		this.requiredItemService = requiredItemService;
	}

	@ApiOperation(value="Get All required item")
	@GetMapping({"/", ""})
	public List<RequiredItem> getRequiredItems(){
		
		LOGGER.info("get RequiredItems");

		return this.requiredItemService.getRequiredItems();
		
	}
	
	@ApiOperation(value="Get a Required Item by Id")
	@GetMapping({"/findById"})
	public RequiredItem getRequiredItem(@RequestParam("id") long id){
		
		LOGGER.info("get required item by id: " + id);

		return this.requiredItemService.getRequiredItem(id);
	}
	
	@ApiOperation(value="Get Required Itens by Description")
	@GetMapping({"/findByDescription"})
	public List<RequiredItem> getRequiredItens(@RequestParam("description") String description){
		
		LOGGER.info("get required itens by description: " + description);

		return this.requiredItemService.getRequiredItem(description);
	}
	
	@ApiOperation(value="Create a Required Item")
	@PostMapping({"/", ""})
	public RequiredItem postRequiredItem(@RequestBody @Valid RequiredItem item) {
		
		LOGGER.info("trying create Required Item");

		RequiredItem requiredItem = this.requiredItemService.postRequiredItem(item);
		
		LOGGER.info("Required Item created");

		return requiredItem;
		
	}

	@ApiOperation(value="Delete a Required Item")
	@DeleteMapping({"/{id}/", "/{id}"})
	public ResponseEntity<?> deleteRequiredItem(@PathVariable(value="id") long id) {
		
		LOGGER.info("trying delete Required Item: " + id);

		this.requiredItemService.deleteRequiredItem(id);
		
		LOGGER.info("Required Item " + id + " deleted");

		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value="Update a Required Item")
	@PutMapping({"/{id}/", "/{id}"})
	public RequiredItem updateRequiredItem(@PathVariable(value="id") long id, @RequestBody @Valid RequiredItem item) {
		
		LOGGER.info("trying update Required Item: " + id);

		RequiredItem requiredItem = this.requiredItemService.updateRequiredItem(id, item); 
		
		LOGGER.info("Required Item " + id + " update");

		return requiredItem;
		
	}
	
	@ApiOperation(value="Get matches")
	@GetMapping({"/match"})
	public List<DonatedItem> getMatch(@RequestParam("description") String descriptionItem,@RequestParam("id") String idReceptor){
		
		LOGGER.info("trying get Match Required Item: ");
		
		List<DonatedItem> matches = this.requiredItemService.getMatch(descriptionItem, idReceptor); 
		
		LOGGER.info("Match Required Item");

		return matches;
	}

}
