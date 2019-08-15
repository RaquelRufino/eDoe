package com.e.doe.manager.user.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.doe.manager.usuario.models.Usuario;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findById(String id);

	List<Usuario> findByName(String Name);
	
}
