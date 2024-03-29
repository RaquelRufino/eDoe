package com.e.doe.manager.item;


import java.util.List;
import java.util.concurrent.TimeUnit;

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
import org.springframework.web.bind.annotation.RestController;

import com.e.doe.manager.utils.PrivilegeUtils;
import com.e.doe.manager.utils.RestConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = RestConstants.ITEM_URI)
@Api(tags = "item")
public class ItemController {
	
	private ItemService itemService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public ItemController(ItemService itemService) {
		
		this.itemService = itemService;
	}
	
	@ApiOperation(value="Get All Items")
	@GetMapping({"/", ""})
	@PreAuthorize("hasRole('" + PrivilegeUtils.PRIVILAGE_USER + "')")
	public List<Item> getItems() throws InterruptedException{
			
		LOGGER.info("get Items");
        TimeUnit.SECONDS.sleep((long) 0.5);

		return itemService.getItems();
	}
	
	@ApiOperation(value="Get a Item")
	@GetMapping({"/{id}/", "/{id}"})
	@PreAuthorize("hasRole('" + PrivilegeUtils.PRIVILAGE_USER + "')")
	public Item getItem(@PathVariable(value="id") long id){
		
		LOGGER.info("get item: " + id);

		return itemService.getItem(id);
	}
	
	
	@ApiOperation(value="Create a Item")
	@PostMapping({"/", ""})
	@PreAuthorize("hasRole('" + PrivilegeUtils.PRIVILAGE_USER + "')")
	public Item postItem(@RequestBody @Valid Item item) {
		
		LOGGER.info("trying create item");
		
		Item newItem = itemService.postItem(item);
		
		LOGGER.info("Item created");

		return newItem;
	}

	@ApiOperation(value="Delete a Item")
	@DeleteMapping({"/{id}/", "/{id}"})
	@PreAuthorize("hasRole('" + PrivilegeUtils.PRIVILAGE_ADMIN + "')")
	public ResponseEntity<?> deleteItem(@PathVariable(value="id") long id) {
		
		LOGGER.info("trying delete item: " + id);

		itemService.deleteItem(id);
		
		LOGGER.info("Item " + id + " deleted");

		return ResponseEntity.ok().build();

	}
	
	@ApiOperation(value="Update a Item")
	@PutMapping({"/{id}/", "/{id}"})
	@PreAuthorize("hasRole('" + PrivilegeUtils.PRIVILAGE_ADMIN + "')")
	public Item updateItem(@PathVariable(value="id") long id, @RequestBody @Valid Item item) {
		
		LOGGER.info("trying update item: " + id);
		
		Item itemUpdate = itemService.updateItem(id, item);
		
		LOGGER.info("Item " + id + " update");

		return itemUpdate;
	}

}
