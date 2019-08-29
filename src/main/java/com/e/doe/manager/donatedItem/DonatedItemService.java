package com.e.doe.manager.donatedItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DonatedItemService {
	
	@Autowired
	private DonatedItemRepository donatedItemRepository;
	
	public List<DonatedItem> getDonatedItems(){
		
		List<DonatedItem> items = donatedItemRepository.findAll();
		
		return items;
	}
	
	public DonatedItem getDonatedItem(long id){
		
		DonatedItem item = donatedItemRepository.findById(id);
		
//		if (item == null) {
//			throw new DonatedItemNotNullRuntimeException(id);
//		}
		return item;
	}
	
	public List<DonatedItem> getDonatedItem(String description){
		
		List<DonatedItem> items = donatedItemRepository.findByDescription(description);
		
//		if (item == null) {
//			throw new DonatedItemNotNullRuntimeException(id);
//		}
		return items;
	}

	public DonatedItem postDonatedItem(DonatedItem item) {

//		if (item == null) {
//		throw new DonatedItemNotNullRuntimeException(id);
//	}
		
		return donatedItemRepository.save(item);
	}
	
	public void deleteDonatedItem(long id) {

//		if (item == null) {
//			throw new DonatedItemNotNullRuntimeException(id);
//		}
		DonatedItem item =  donatedItemRepository.findById(id);
		
		donatedItemRepository.delete(item);
	}
	
	public DonatedItem updateDonatedItem(long id, DonatedItem item) {
		
		DonatedItem existingItem =  donatedItemRepository.findById(id);
		
//		if (existingItem == null) {
//		throw new DonatedItemNotNullRuntimeException(id);
//	}
		
		if (!(item.getTags() == null) && !(item.getTags().length == 0)) {
			existingItem.setTags(item.getTags());
		}
		
		if ((item.getAmount() > 0)) {
			existingItem.setAmount(item.getAmount());
		}

		return this.donatedItemRepository.save(existingItem);
	}
	
	
}
