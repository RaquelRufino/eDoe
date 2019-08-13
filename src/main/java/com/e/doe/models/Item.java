package com.e.doe.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Representacao de um Item na aplicacao.
 *
 */

@Entity
@Table(name="ITEM")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String descricao;
	
	private int quantidade;
	
	private String[] tags;
	
	private Usuario usuario;
	
	/**
	 * 
	 * Retorna o id do item.
	 * 
	 * @return id do item
	 */
	
	public long getId() {
		return id;
	}

	/**
	 * 
	 * Atualiza o id do tipo.
	 * 
	 * @param id novo do item
	 */
	
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * Retorna a descricao do item.
	 * 
	 * @return descricao do item
	 */
	
	public String getDescricao() {
		return descricao;
	}

	/**
	 * 
	 * Atualiza a descricao do tipo.
	 * 
	 * @param descricao nova do item
	 */
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * 
	 * Retorna a quantidade de itens.
	 * 
	 * @return quantidade de itens
	 */
	
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * 
	 * Atualiza a quantidade do tipo.
	 * 
	 * @param quantidade nova do item
	 */
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * 
	 * Retorna as Tags do item.
	 * 
	 * @return id do item
	 */
	
	public String[] getTags() {
		return tags;
	}
	
	/**
	 * 
	 * Atualiza as tags do tipo.
	 * 
	 * @param tags novas do item
	 */

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	/**
	 * 
	 * Retorna o Usuario do item.
	 * 
	 * @return usuario do item
	 */
	
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * 
	 * Atualiza o Usuario do tipo.
	 * 
	 * @param Usuario novo do item
	 */
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


}
