package com.e.doe.manager.donatedItem;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.e.doe.manager.donatedItem.DonatedItem;

@Repository("donatedItemRepository")
public interface DonatedItemRepository extends JpaRepository<DonatedItem, Long>{

	DonatedItem findByIdDonation(String idDonation);
	
	List<DonatedItem> findByDescription(String description);
	
	List<DonatedItem> findAll();
	
	DonatedItem findByDescriptionAndIdDonation(String description, String idDonation);

}
