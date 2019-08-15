package com.e.doe.manager.usuario.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.doe.manager.usuario.models.Usuario;


@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findById(String id);

	List<Usuario> findByNome(String Nome);
	
}
