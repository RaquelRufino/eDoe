package com.e.doe.manager.item;

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
@RequestMapping(value = RestConstants.ITEM_URI)
@Api(tags = "item")
public class ItemController {
	
	private ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@ApiOperation(value="Get All Items")
	@GetMapping({"/", ""})
	public List<Item> getItems(){
				
		return itemService.getItems();
	}
	
	@ApiOperation(value="Get a Item")
	@GetMapping({"/{id}/", "/{id}"})
	public String getItem(@PathVariable(value="id") long id){
		return itemService.getItem(id);
	}
	
	
	@ApiOperation(value="Create a Item")
	@PostMapping({"/", ""})
	public Item postItem(@RequestBody @Valid Item item) {
		
		return itemService.postItem(item);
	}

	@ApiOperation(value="Delete a Item")
	@DeleteMapping({"/{id}/", "/{id}"})
	public ResponseEntity<?> deleteItem(@PathVariable(value="id") long id) {
		
		itemService.deleteItem(id);
		return ResponseEntity.ok().build();

	}
	
	@ApiOperation(value="Update a Item")
	@PutMapping({"/{id}/", "/{id}"})
	public Item updateItem(@PathVariable(value="id") long id, @RequestBody @Valid Item item) {
		
		return itemService.updateItem(id, item);
	}

}
