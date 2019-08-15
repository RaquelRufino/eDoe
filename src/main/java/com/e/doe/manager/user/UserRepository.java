package com.e.doe.manager.user;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findById(String id);

	List<User> findByName(String Name);
	
}
