package com.e.doe.manager.item.models;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_item")
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "amount")
	private int amount;
	
	@Column(name = "tags")
	private String[] tags;
	
	@Column(name = "idDonation")
	private String idDonation;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}


	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getIdDonation() {
		return idDonation;
	}

	
	public void setIdDonation(String idDonation) {
		this.idDonation = idDonation;
	}

	@Override
	public String toString() {
		return this.getId() + " - " + this.getDescription() + ", tags: " + this.tagsEmString() +
				", quantidade: " + this.getAmount() ;
	  }

	private String tagsEmString() {
		return "[" + String.join(", ", this.getTags()) + "]";

	}
	


}
