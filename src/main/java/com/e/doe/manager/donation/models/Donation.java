package com.e.doe.manager.donation.models;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_donation")
public class Donation implements Serializable {
	
	private static final long serialVersionUID = -9051052759732137812L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
  
	@Column(name = "date")
	private String date;
  
	@Column(name = "idDonation")
	private String idDonation;
  
	@Column(name = "description")
	private String description;
  
	@Column(name = "amount")
	private int amount;
  
	@Column(name = "idReceptor")
	private String idReceptor;
	
	public Donation() {
	}

	
	public long getId() {
		return id;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getDate() {
		return date;
	}
	
	
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getIdDonation() {
		return idDonation;
	}
	
	
	public void setIdDonation(String idDonation) {
		this.idDonation = idDonation;
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
	

	public String getIdReceptor() {
		return idReceptor;
	}
	
	public void setIdReceptor(String idReceptor) {
		this.idReceptor = idReceptor;
	}

}
