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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.e.doe.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.e.doe.models.Usuario;

import java.util.ArrayList;
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
	@GetMapping(value = "/usuarios")
	public List<Usuario> getUsuarios(){
		return usuarioRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um usuario pelo id")
	@GetMapping("/usuario/{id}")
	public Usuario getUsuario(@PathVariable(value="id") String id){
		return usuarioRepository.findById(id);
	}
	
	@ApiOperation(value="Retorna uma lista de usuarios pelo nome")
	@RequestMapping("/usuarioByNome/{nome}")
	public String GetUsuariosByName(@PathVariable(value="nome") String nome){

		List<Usuario> usuarios = usuarioRepository.findByNome(nome);
		String st = "";
		
		for (int i = 0; i < usuarios.size() - 1; i++) {
			st += usuarios.get(i).toString() + " | ";
		}

		st += usuarios.get(usuarios.size() - 1).toString();
		return st;
	}
	
	@ApiOperation(value="Salva um usuario")
	@PostMapping("/usuario")
	public Usuario postUsuario(@RequestBody @Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@ApiOperation(value="Deleta um usuario")
	@DeleteMapping("/usuario/{id}")
	public String deletaUsuario(@PathVariable(value="id") String id) {
		Usuario usuario =  usuarioRepository.findById(id);
		usuarioRepository.delete(usuario);
		return "Usuario deletado";
	}
	
	@ApiOperation(value="Atualiza um usuario")
	@PutMapping("/usuario")
	public Usuario atualizaUsuario(@RequestBody @Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}


}
