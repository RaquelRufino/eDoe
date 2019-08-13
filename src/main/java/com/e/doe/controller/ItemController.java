package com.e.doe.controller;

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

import com.e.doe.models.Item;
import com.e.doe.repository.ItemRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/edoe")
@Api(value="API REST eDoe")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@ApiOperation(value="Retorna uma lista de itens")
	@GetMapping("/itens")
	public List<Item> getitems(){
		return itemRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um item unico")
	@GetMapping("/item/{id}")
	public Item getitem(@PathVariable(value="id") long id){
		return itemRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um item")
	@PostMapping("/item")
	public Item postitem(@RequestBody @Valid Item item) {
		return itemRepository.save(item);
	}

	@ApiOperation(value="Deleta um item")
	@DeleteMapping("/item/{id}")
	public void deletaitem(@PathVariable(value="id") long id) {
		Item item =  itemRepository.findById(id);
		itemRepository.delete(item);
	}
	
	@ApiOperation(value="Atualiza um item")
	@PutMapping("/item")
	public Item atualizaitem(@RequestBody @Valid Item item) {
		return itemRepository.save(item);
	}
}
