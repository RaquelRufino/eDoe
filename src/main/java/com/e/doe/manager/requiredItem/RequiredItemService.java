package com.e.doe.manager.requiredItem;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.doe.manager.user.User;
import com.e.doe.manager.user.UserRepository;


@Service
public class RequiredItemService {
	
	@Autowired
	private RequiredItemRepository requiredItemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public String getRequiredItems(){
		
		List<RequiredItem> items = requiredItemRepository.findAll();
		
		return items.stream()	      
				.map(RequiredItem::toString)
				.collect(Collectors.joining(" | "));
	}
	
	public String getRequiredItem(long id){
		
		RequiredItem item = requiredItemRepository.findById(id);
		
//		if (item == null) {
//			throw new DonatedItemNotNullRuntimeException(id);
//		}
		return item.toString();
	}
	
	public String getRequiredItem(String description){
		
		List<RequiredItem> items = requiredItemRepository.findByDescription(description);
		
//		if (item == null) {
//			throw new DonatedItemNotNullRuntimeException(id);
//		}
		return items.stream()	      
				.map(RequiredItem::toString)
				.collect(Collectors.joining(" | "));
	}

	public String postRequiredItem(RequiredItem item) {

//		if (item == null) {
//		throw new DonatedItemNotNullRuntimeException(id);
//	}
		
		return requiredItemRepository.save(item).toString();
	}
	
	public void deleteRequiredItem(long id) {

//		if (item == null) {
//			throw new DonatedItemNotNullRuntimeException(id);
//		}
		RequiredItem item =  requiredItemRepository.findById(id);
		
		requiredItemRepository.delete(item);
	}
	
	public String updateRequiredItem(long id, RequiredItem item) {
		
		RequiredItem existingItem = requiredItemRepository.findById(id);
		
//		if (existingItem == null) {
//		throw new DonatedItemNotNullRuntimeException(id);
//	}
		
		if (!(item.getTags() == null) && !(item.getTags().length == 0)) {
			existingItem.setTags(item.getTags());
		}
		
		if ((item.getAmount() > 0)) {
			existingItem.setAmount(item.getAmount());
		}

		return this.requiredItemRepository.save(existingItem).toString();
	}
	
	public String getUserIdentification(String idRequired) {
		User user = userRepository.findById(idRequired);
	    return user.getStatus() + ": " + user.geidentification();
	}
	
}
