package com.e.doe.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.doe.models.Item;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long>{

	Item findById(long id);
	
	List<Item> findByDescricao(String descricao);
	
	List<Item> findAll();
}
