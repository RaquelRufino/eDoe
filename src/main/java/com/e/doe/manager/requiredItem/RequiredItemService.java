package com.e.doe.manager.requiredItem;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

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
	
	public String getMatch(String descriptionItem, String idReceptor){
		
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
		
		return itensMatch.stream()	      
				.map(DonatedItem::toString)
				.collect(Collectors.joining(" | "));
		
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
