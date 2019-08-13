package com.e.doe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e.doe.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findById(long id);

}
