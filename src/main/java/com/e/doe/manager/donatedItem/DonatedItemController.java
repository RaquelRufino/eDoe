package com.e.doe.manager.donatedItem;


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
import com.e.doe.manager.user.User;
import com.e.doe.manager.donatedItem.DonatedItem;
import com.e.doe.manager.donatedItem.DonatedItemRepository;

import com.e.doe.manager.utils.RestConstants;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(value = RestConstants.DONATED_ITEM_URI)
@Api(tags = "donatedItem")
public class DonatedItemController {
	
	@Autowired
	DonatedItemRepository donatedItemRepository;
	UserRepository usuarioRepository;
	
	@ApiOperation(value="Get All donated item")
	@GetMapping({"/", ""})
	public String getDonatedItems(){
		
		List<DonatedItem> items =  donatedItemRepository.findAll();
		
		String Items = "";

		for (DonatedItem item : items) {
			Items += item.toString() ;
					//+ ", " + this.getUsuarioIdentificacao(item.getIdDoador()) + " | ";
		}

		Items += items.get(items.size() - 1).toString();
		return Items;
	}
	
	@ApiOperation(value="Get a Donated Item")
	@GetMapping({"/{id}/", "/{id}"})
	public String getDonatedItem(@PathVariable(value="id") long id){
		return donatedItemRepository.findById(id).toString();
	}
	
	
	@ApiOperation(value="Create a Donated Item")
	@PostMapping({"/", ""})
	public DonatedItem postDonatedItem(@RequestBody @Valid DonatedItem item) {

		return donatedItemRepository.save(item);
	}

	@ApiOperation(value="Delete a Donated Item")
	@DeleteMapping({"/{id}/", "/{id}"})
	public void deleteDonatedItem(@PathVariable(value="id") long id) {
		DonatedItem item =  donatedItemRepository.findById(id);
		donatedItemRepository.delete(item);
	}
	
	@ApiOperation(value="Update a Donated Item")
	@PutMapping({"/{id}/", "/{id}"})
	public DonatedItem updateDonatedItem(@PathVariable(value="id") long id, @RequestBody @Valid DonatedItem item) {
		
		DonatedItem existingItem =  donatedItemRepository.findById(id);
		if (!(item.getTags() == null) && !(item.getTags().length == 0)) {
			existingItem.setTags(item.getTags());
		}
		
		if ((item.getAmount() > 0)) {
			existingItem.setAmount(item.getAmount());
		}

		return donatedItemRepository.save(existingItem);
	}
	
	public String getUsuarioIdentificacao(String idDonation) {
		User user = this.usuarioRepository.findById(idDonation);
	    return user.getStatus() + ": " + user.geidentification();
	}
}
