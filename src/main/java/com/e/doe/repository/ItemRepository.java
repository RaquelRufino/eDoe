package com.e.doe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e.doe.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

	Item findById(long id);
}
