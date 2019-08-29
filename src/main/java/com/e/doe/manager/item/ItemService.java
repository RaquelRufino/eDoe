package com.e.doe.manager.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemService {


	@Autowired
	private ItemRepository itemRepository;
	
	
	public List<Item> getItems(){
		
		List<Item> items = itemRepository.findAll();
		
		return items;
	}
	
	public Item getItem(long id){
		return itemRepository.findById(id);
	}
	
	
	public Item postItem(Item item) {

		return itemRepository.save(item);
	}

	
	public void deleteItem(long id) {
		Item item = itemRepository.findById(id);
		itemRepository.delete(item);
	}
	
	public Item updateItem(long id, Item item) {
		
		Item existingItem =  itemRepository.findById(id);
		
		existingItem.setDescription(item.getDescription());
		return itemRepository.save(existingItem);
	}
}
