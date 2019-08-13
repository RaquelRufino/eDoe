package com.e.doe.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Representacao de um Usuario na aplicacao.
 *
 */
@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String nome;
	
	private String email;
		
	private String telefone;
	
	private String classe;
	
	private String status;


	/**
	 * 
	 * Retorna o nome do usuario.
	 * 
	 * @return nome do usuario
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * Atualiza o nome do usuario.
	 * 
	 * @param nome novo do usuario
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * Retorna o email do usuario.
	 * 
	 * @return email do usuario
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * Atualiza o email do usuario.
	 *
	 * @param email novo do usuario
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * Retorna o telefone do usuario.
	 * 
	 * @return telefone do usuario
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * 
	 * Atualiza o telefone do usuario.
	 * 
	 * @param telefone novo do usuario
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * 
	 * Retorna a classe do usuario.
	 * @return classe do usuario
	 */
	public String getClasse() {
		return classe;
	}

	/**
	 * 
	 * Atualiza a classe do usuario.
	 * @param classe nova do usuario
	 */
	public void setClasse(String classe) {
		this.classe = classe;
	}

	/**
	 * 
	 * Retorna o valor atual do status do usuario.
	 * @return o valor do status do usuario
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 
	 * Atualiza o valor atual do status do usuario.
	 * @param valor novo do status do usuario
	 */
	public void setStatus(String status) {
		this.status = status;
	}


}
