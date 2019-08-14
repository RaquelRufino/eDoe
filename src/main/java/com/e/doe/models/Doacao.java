package com.e.doe.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Representacao de uma Doacao na aplicacao.
 *
 */

@Entity
@Table(name="DOACAO")
public class Doacao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  @Column(name = "id")
	  private long id;
	  
	  @Column(name = "data")
	  private String data;
	  
	  @Column(name = "idDoador")
	  private long idDoador;
	  
	  @Column(name = "descricao")
	  private String descricao;
	  
	  @Column(name = "quantidade")
	  private int quantidade;
	  
	  @Column(name = "idReceptor")
	  private long idReceptor;
	
	/**
	 * 
	 * Retorna o id da doacao.
	 * 
	 * @return id da doacao
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * 
	 * Atualiza o id da doacao.
	 * 
	 * @param id novo da doacao
	 */
	
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * Retorna a data da doacao.
	 * 
	 * @return data da doacao
	 */
	
	public String getData() {
		return data;
	}
	
	/**
	 * 
	 * Atualiza a data da doacao.
	 * 
	 * @param data nova da doacao
	 */
	
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * 
	 * Retorna o doador da doacao.
	 * 
	 * @return id da doacao
	 */
	
	public long getIdDoador() {
		return idDoador;
	}
	
	/**
	 * 
	 * Atualiza o id do doador da doacao.
	 * 
	 * @param id novo do doador da doacao
	 */
	
	public void setIdDoador(long idDoador) {
		this.idDoador = idDoador;
	}
	
	/**
	 * 
	 * Retorna a descricao da doacao.
	 * 
	 * @return descricao da doacao
	 */
	
	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * 
	 * Atualiza a descricao da doacao.
	 * 
	 * @param descricao nova da doacao
	 */
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * 
	 * Retorna a quantidade da doacao.
	 * 
	 * @return quantidade da doacao
	 */
	
	public int getQuantidade() {
		return quantidade;
	}
	
	/**
	 * 
	 * Atualiza a quantidade da doacao.
	 * 
	 * @param quantidade nova da doacao
	 */
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	/**
	 * 
	 * Retorna o id do doador da doacao.
	 * 
	 * @return id do doador da doacao
	 */
	public long getIdReceptor() {
		return idReceptor;
	}
	
	/**
	 * 
	 * Atualiza o id do receptor da doacao.
	 * 
	 * @param id novo do receptor da doacao
	 */
	public void setIdReceptor(long idReceptor) {
		this.idReceptor = idReceptor;
	}

}
