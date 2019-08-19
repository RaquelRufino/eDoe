package com.e.doe.manager.donatedItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.doe.manager.user.User;
import com.e.doe.manager.user.UserRepository;


@Service
public class DonatedItemService {
	
	@Autowired
	private DonatedItemRepository donatedItemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public String getDonatedItems(){
		
		List<DonatedItem> items = donatedItemRepository.findAll();
		
		String Items = "";

		for (DonatedItem item : items) {
			Items += item.toString() ;
					//+ ", " + this.getUsuarioIdentificacao(item.getIdDoador()) + " | ";
		}

		Items += items.get(items.size() - 1).toString();
		return Items;
	}
	
	public String getDonatedItem(long id){
		
		DonatedItem item = donatedItemRepository.findById(id);
		
//		if (item == null) {
//			throw new DonatedItemNotNullRuntimeException(id);
//		}
		return item.toString();
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
	
	public String getUserIdentification(String idDonation) {
		User user = userRepository.findById(idDonation);
	    return user.getStatus() + ": " + user.geidentification();
	}

}