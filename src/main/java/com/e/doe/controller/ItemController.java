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
import com.e.doe.models.Usuario;
import com.e.doe.repository.ItemRepository;
import com.e.doe.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/edoe")
@Api(value="API REST eDoe")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	UsuarioRepository usuarioRepository;
	
	@ApiOperation(value="Retorna uma lista de itens")
	@GetMapping("/itens")
	public String getItens(){
		
		List<Item> itens =  itemRepository.findAll();
		
		String Itens = "";

		for (Item item : itens) {
			Itens += item.toString() ;
					//+ ", " + this.getUsuarioIdentificacao(item.getIdDoador()) + " | ";
		}

		Itens += itens.get(itens.size() - 1).toString();
		return Itens;
	}
	
	@ApiOperation(value="Retorna um item unico")
	@GetMapping("/item/{id}")
	public String getItem(@PathVariable(value="id") long id){
		return itemRepository.findById(id).toString();
	}
	
	@ApiOperation(value="Adicionando descritor")
	@PostMapping("/descritor")
	public Item postDescricao(@RequestBody @Valid Item item) {
		
		String descricao = item.getDescricao();
		item.setDescricao(descricao.toLowerCase());				
		
		return itemRepository.save(item);
	}
	
	@ApiOperation(value="Adicionando itens")
	@PostMapping("/item")
	public Item postItem(@RequestBody @Valid Item item) {

		return itemRepository.save(item);
	}

	@ApiOperation(value="Deleta um item")
	@DeleteMapping("/item/{id}")
	public void deletaitem(@PathVariable(value="id") long id) {
		Item item =  itemRepository.findById(id);
		itemRepository.delete(item);
	}
	
	@ApiOperation(value="Atualiza um item")
	@PutMapping("/item/{id}")
	public Item atualizaitem(@PathVariable(value="id") long id, @RequestBody @Valid Item item) {
		
		Item existingItem =  itemRepository.findById(id);
		if (!(item.getTags() == null) && !(item.getTags().length == 0)) {
			existingItem.setTags(item.getTags());
		}
		
		if ((item.getQuantidade() > 0)) {
			existingItem.setQuantidade(item.getQuantidade());
		}

		return itemRepository.save(existingItem);
	}
	
	public String getUsuarioIdentificacao(String idDoador) {
		Usuario usuario = this.usuarioRepository.findById(idDoador);
	    return usuario.getStatus() + ": " + usuario.getIdentificacao();
	}
}
