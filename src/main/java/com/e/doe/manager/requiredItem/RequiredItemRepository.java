package com.e.doe.manager.requiredItem;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("requiredItemRepository")
public interface RequiredItemRepository extends JpaRepository<RequiredItem, Long>{

	RequiredItem findById(long id);
	
	List<RequiredItem> findByDescription(String description);
	
	List<RequiredItem> findAll();
	
	RequiredItem findByDescriptionAndIdReceptor(String description, String idReceptor);

}
