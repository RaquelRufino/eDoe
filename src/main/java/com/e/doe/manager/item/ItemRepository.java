package com.e.doe.manager.item;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long>{

	Item findById(long id);
	
	List<Item> findAll();
}
