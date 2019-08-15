package com.e.doe.manager.item;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e.doe.manager.user.UserRepository;
import com.e.doe.manager.utils.RestConstants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = RestConstants.ITEM_URI)
@Api(tags = "item")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	UserRepository usuarioRepository;
	
	@ApiOperation(value="Get All Items")
	@GetMapping({"/", ""})
	public List<Item> getItems(){
		
		List<Item> items = itemRepository.findAll();
		
		return items;
	}
	
	@ApiOperation(value="Get a Item")
	@GetMapping({"/{id}/", "/{id}"})
	public String getItem(@PathVariable(value="id") long id){
		return itemRepository.findById(id).toString();
	}
	
	
	@ApiOperation(value="Create a Item")
	@PostMapping({"/", ""})
	public Item postItem(@RequestBody @Valid Item item) {

		return itemRepository.save(item);
	}

	@ApiOperation(value="Delete a Item")
	@DeleteMapping({"/{id}/", "/{id}"})
	public void deleteItem(@PathVariable(value="id") long id) {
		Item item = itemRepository.findById(id);
		itemRepository.delete(item);
	}
	
	@ApiOperation(value="Update a Item")
	@PutMapping({"/{id}/", "/{id}"})
	public Item updateItem(@PathVariable(value="id") long id, @RequestBody @Valid Item item) {
		
		Item existingItem =  itemRepository.findById(id);
		return itemRepository.save(existingItem);
	}

}
