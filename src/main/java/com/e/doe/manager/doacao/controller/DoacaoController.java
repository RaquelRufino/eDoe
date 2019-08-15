package com.e.doe.manager.doacao.controller;


import java.util.List;

import javax.validation.Valid;

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

import com.e.doe.manager.doacao.models.Doacao;
import com.e.doe.manager.doacao.repositories.DoacaoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/edoe")
@Api(value="API REST eDoe")

public class DoacaoController {
	
	@Autowired
	DoacaoRepository doacaoRepository;
	
	@ApiOperation(value="Retorna uma lista de doacoes")
	@GetMapping("/doacoes")
	public List<Doacao> getdoacoes(){
		return doacaoRepository.findAll();
	}
	
	@ApiOperation(value="Retorna uma doacao unica")
	@GetMapping("/doacao/{id}")
	public Doacao getdoacao(@PathVariable(value="id") long id){
		return doacaoRepository.findById(id);
	}
	
	@ApiOperation(value="Salva uma doacao")
	@PostMapping("/doacao")
	public Doacao postdoacao(@RequestBody @Valid Doacao doacao) {
		return doacaoRepository.save(doacao);
	}

	@ApiOperation(value="Deleta uma doacao")
	@DeleteMapping("/doacao/{id}")
	public void deletadoacao(@PathVariable(value="id") long id) {
		Doacao doacao =  doacaoRepository.findById(id);
		doacaoRepository.delete(doacao);
	}
	
	@ApiOperation(value="Atualiza uma doacao")
	@PutMapping("/doacao")
	public Doacao atualizadoacao(@RequestBody @Valid Doacao doacao) {
		return doacaoRepository.save(doacao);
	}
}
