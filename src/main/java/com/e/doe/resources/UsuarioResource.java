package com.e.doe.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e.doe.repository.UsuarioRepository;
import com.e.doe.models.Usuario;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/edoe")
public class UsuarioResource {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario getUsuario(@PathVariable(value="id") long id){
		return usuarioRepository.findById(id);
	}
	
	@PostMapping("/usuario")
	public Usuario postUsuario(@RequestBody @Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping("/usuario/{id}")
	public void deletaUsuario(@PathVariable(value="id") long id) {
		Usuario usuario =  usuarioRepository.findById(id);
		usuarioRepository.delete(usuario);
	}
	
	@PutMapping("/usuario")
	public Usuario atualizaUsuario(@RequestBody @Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}
