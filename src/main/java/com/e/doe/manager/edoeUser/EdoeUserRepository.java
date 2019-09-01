package com.e.doe.manager.edoeUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EdoeUserRepository extends JpaRepository<EdoeUser, Long> {
	
	EdoeUser findByUsername(String username);
}
