package com.e.doe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e.doe.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.e.doe.models.Usuario;

import java.util.List;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/edoe")
@Api(value="API REST eDoe")

public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@ApiOperation(value="Retorna uma lista de Usuarios")
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um usuario unico")
	@GetMapping("/usuario/{id}")
	public Usuario getUsuario(@PathVariable(value="id") long id){
		return usuarioRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um usuario")
	@PostMapping("/usuario")
	public Usuario postUsuario(@RequestBody @Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@ApiOperation(value="Deleta um usuario")
	@DeleteMapping("/usuario/{id}")
	public void deletaUsuario(@PathVariable(value="id") long id) {
		Usuario usuario =  usuarioRepository.findById(id);
		usuarioRepository.delete(usuario);
	}
	
	@ApiOperation(value="Atualiza um usuario")
	@PutMapping("/usuario")
	public Usuario atualizaUsuario(@RequestBody @Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}
