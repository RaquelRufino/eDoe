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
	
	public DonatedItem getDonatedItem(String idDonation){
		
		DonatedItem item = donatedItemRepository.findByIdDonation(idDonation);
		
		if (item == null) {
			throw new DonatedItemNotFoundException(idDonation);
		}
		
		return item;
	}
	
	public List<DonatedItem> getDonatedItemByDescription(String description){
		
		List<DonatedItem> items = donatedItemRepository.findByDescription(description);
		
		if (items == null) {
			throw new DonatedItemDescriptionNotFoundException(description);
		}

		return items;
	}

	public DonatedItem postDonatedItem(DonatedItem item) {

		if (item == null) {
			throw new DonatedItemNullException();
		}
		
		return donatedItemRepository.save(item);
	}
	
	public void deleteDonatedItem(String idDonation) {

		DonatedItem item =  donatedItemRepository.findByIdDonation(idDonation);

		if (item == null) {
			throw new DonatedItemNotFoundException(idDonation);
		}
		
		donatedItemRepository.delete(item);
	}
	
	public DonatedItem updateDonatedItem(String idDonation, DonatedItem item) {
		
		DonatedItem existingItem =  donatedItemRepository.findByIdDonation(idDonation);
		
		if (item == null) {
			throw new DonatedItemNotFoundException(idDonation);
		}
		
		if (!(item.getTags() == null) && !(item.getTags().length == 0)) {
			existingItem.setTags(item.getTags());
		}
		
		if ((item.getAmount() > 0)) {
			existingItem.setAmount(item.getAmount());
		}

		return this.donatedItemRepository.save(existingItem);
	}
	
	
}
