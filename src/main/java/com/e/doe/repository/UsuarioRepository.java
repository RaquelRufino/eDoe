package com.e.doe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.doe.models.Usuario;


@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findById(String id);

	List<Usuario> findByNome(String Nome);
	
}
