package com.e.doe.manager.item.controller;


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

import com.e.doe.manager.item.models.Item;
import com.e.doe.manager.usuario.models.Usuario;
import com.e.doe.manager.usuario.repositories.UsuarioRepository;
import com.e.doe.manager.utils.RestConstants;
import com.e.doe.manager.item.repositories.ItemRepository;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = RestConstants.ITEM_URI)
@Api(tags = "Item")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	UsuarioRepository usuarioRepository;
	
	@ApiOperation(value="Get All itens")
	@GetMapping({"/", ""})
	public String getItems(){
		
		List<Item> items =  itemRepository.findAll();
		
		String Items = "";

		for (Item item : items) {
			Items += item.toString() ;
					//+ ", " + this.getUsuarioIdentificacao(item.getIdDoador()) + " | ";
		}

		Items += items.get(items.size() - 1).toString();
		return Items;
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

	@ApiOperation(value="Delete a item")
	@DeleteMapping({"/{id}/", "/{id}"})
	public void deleteItem(@PathVariable(value="id") long id) {
		Item item =  itemRepository.findById(id);
		itemRepository.delete(item);
	}
	
	@ApiOperation(value="Update a item")
	@PutMapping({"/{id}/", "/{id}"})
	public Item updateItem(@PathVariable(value="id") long id, @RequestBody @Valid Item item) {
		
		Item existingItem =  itemRepository.findById(id);
		if (!(item.getTags() == null) && !(item.getTags().length == 0)) {
			existingItem.setTags(item.getTags());
		}
		
		if ((item.getAmount() > 0)) {
			existingItem.setAmount(item.getAmount());
		}

		return itemRepository.save(existingItem);
	}
	
	public String getUsuarioIdentificacao(String idDonation) {
		Usuario user = this.usuarioRepository.findById(idDonation);
	    return user.getStatus() + ": " + user.getIdentificacao();
	}
}
