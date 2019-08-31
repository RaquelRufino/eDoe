package com.e.doe.manager.requiredItem;

import java.util.ArrayList;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.doe.manager.donatedItem.DonatedItem;
import com.e.doe.manager.donatedItem.DonatedItemRepository;


@Service
public class RequiredItemService {
	
	@Autowired
	private RequiredItemRepository requiredItemRepository;
	
	@Autowired
	private DonatedItemRepository donatedItemRepository;

	
	public List<RequiredItem> getRequiredItems(){
		
		List<RequiredItem> items = requiredItemRepository.findAll();
		
		return items;
	}
	
	public RequiredItem getRequiredItem(String idReceptor){
		
		RequiredItem item = requiredItemRepository.findByIdReceptor(idReceptor);
		
//		if (item == null) {
//			throw new DonatedItemNotNullRuntimeException(id);
//		}
		return item;
	}
	
	public List<RequiredItem> getRequiredItemByDescription(String description){
		
		List<RequiredItem> items = requiredItemRepository.findByDescription(description);
		
//		if (item == null) {
//			throw new DonatedItemNotNullRuntimeException(id);
//		}
		return items;
	}

	public RequiredItem postRequiredItem(RequiredItem item) {

//		if (item == null) {
//		throw new DonatedItemNotNullRuntimeException(id);
//	}
		
		return requiredItemRepository.save(item);
	}
	
	public void deleteRequiredItem(String idReceptor) {

//		if (item == null) {
//			throw new DonatedItemNotNullRuntimeException(id);
//		}
		RequiredItem item =  requiredItemRepository.findByIdReceptor(idReceptor);
		
		requiredItemRepository.delete(item);
	}
	
	public RequiredItem updateRequiredItem(String idReceptor, RequiredItem item) {
		
		RequiredItem existingItem = requiredItemRepository.findByIdReceptor(idReceptor);
		
//		if (existingItem == null) {
//		throw new DonatedItemNotNullRuntimeException(id);
//	}
		
		if (!(item.getTags() == null) && !(item.getTags().length == 0)) {
			existingItem.setTags(item.getTags());
		}
		
		if ((item.getAmount() > 0)) {
			existingItem.setAmount(item.getAmount());
		}
		
		existingItem.setidReceptor(item.getidReceptor());
		return this.requiredItemRepository.save(existingItem);
	}
	
	public List<DonatedItem> getMatch(String descriptionItem, String idReceptor){
		
		RequiredItem itemRequired = requiredItemRepository.findByDescriptionAndIdReceptor(descriptionItem, idReceptor);

		List<DonatedItem> itens = donatedItemRepository.findByDescription(descriptionItem);
		
		List<DonatedItem> itensMatch =  new ArrayList<>();
	
		if (itens.size() > 0) {
			

			for (DonatedItem i : itens) {
				updatePontuacaoMatchDoItem(itemRequired, i);
				if (i.getScore() > 0)
					itensMatch.add(i);
			}
		}
		
		return itensMatch;
		
	}
	
	private void updatePontuacaoMatchDoItem(RequiredItem requiredItem, DonatedItem donatedItem) {
		int score = 20;
		if (donatedItem.getTags().length >= requiredItem.getTags().length) {
			score += calculateScore(requiredItem.getTags(), donatedItem.getTags());
		} else if (donatedItem.getTags().length < requiredItem.getTags().length) {
			score += calculateScore(donatedItem.getTags(), requiredItem.getTags());
		}
		requiredItem.setScore(score);
		
		requiredItemRepository.save(requiredItem);
	}

	
	private int calculateScore(String[] itemLessTags, String[] itemMoreTags) {
		
		int score = 0;
		int i = 0;
		while (itemMoreTags.length > i) {
			if (itemLessTags.length > i) {
				if (itemMoreTags[i].equals(itemLessTags[i]))
					score += 10;
				else if (Arrays.stream(itemMoreTags).anyMatch(itemLessTags[i]::equals))
					score += 5;
			} else if (itemLessTags.length < i) {
				score += 5;
			}
			i++;
		}
		
		
		return score;
	}
	
	
}
