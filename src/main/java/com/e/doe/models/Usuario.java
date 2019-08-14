package com.e.doe.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name = "identificador")
	private String id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;


	@Column(name = "telefone")
	private String telefone;


	@Column(name = "classe")
	private String classe;

	@Column(name = "status")
	private String status;
	
	
	/**
	 * 
	 * Retorna o identificador do usuario.
	 * 
	 * @return identificador do usuario
	 */
	public String getId() {
		return id;
	}


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
	
	@Override
	public String toString() {
		return this.getIdentificacao() + ", " + this.email + ", " + this.telefone + ", status: " + this.status;
	}

	/**
	 * 
	 * Retorna a identificacao completa do usuario,
	 *
	 * @return A identificacao do usuario.
	 */
	public String getIdentificacao() {
		return this.nome + "/" + this.id;
	}

}
