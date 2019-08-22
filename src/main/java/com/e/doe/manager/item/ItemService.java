package com.e.doe.manager.item;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemService {


	@Autowired
	private ItemRepository itemRepository;
	
	
	public String getItems(){
		
		List<Item> items = itemRepository.findAll();
		
		return items.stream()	      
					.map(Item::toString)
					.collect(Collectors.joining(" | "));
	}
	
	public String getItem(long id){
		return itemRepository.findById(id).toString();
	}
	
	
	public String postItem(Item item) {

		return itemRepository.save(item).toString();
	}

	
	public void deleteItem(long id) {
		Item item = itemRepository.findById(id);
		itemRepository.delete(item);
	}
	
	public String updateItem(long id, Item item) {
		
		Item existingItem =  itemRepository.findById(id);
		
		existingItem.setDescription(item.getDescription());
		return itemRepository.save(existingItem).toString();
	}
}
