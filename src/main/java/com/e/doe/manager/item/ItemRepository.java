package com.e.doe.manager.item.repositories;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.doe.manager.item.models.Item;


@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long>{

	Item findById(long id);
	
	List<Item> findByDescription(String description);
	
	List<Item> findAll();
}
