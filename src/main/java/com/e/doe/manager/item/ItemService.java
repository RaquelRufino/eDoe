package com.e.doe.manager.item;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;


@Service
public class ItemService {


	@Autowired
	private ItemRepository itemRepository;
	
    @Cacheable(cacheNames = Item.CACHE_NAME, key="#root.method.name")
	public List<Item> getItems(){
		
		List<Item> items = itemRepository.findAll();
		
		return items;
	}
    
    @Cacheable(cacheNames = Item.CACHE_NAME, key="#identifier")
	public Item getItem(long id){
		return itemRepository.findById(id);
	}
	
    @CacheEvict(cacheNames = Item.CACHE_NAME, allEntries = true)
	public Item postItem(Item item) {

		return itemRepository.save(item);
	}

    @CacheEvict(cacheNames = Item.CACHE_NAME, key="#identifier")
	public void deleteItem(long id) {
		Item item = itemRepository.findById(id);
		itemRepository.delete(item);
	}
	
    @CachePut(cacheNames = Item.CACHE_NAME, key="#company.getIdentifier()")
	public Item updateItem(long id, Item item) {
		
		Item existingItem =  itemRepository.findById(id);
		
		existingItem.setDescription(item.getDescription());
		return itemRepository.save(existingItem);
	}
}
