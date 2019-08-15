package com.e.doe.manager.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name="tb_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Email
	@Column(name = "email", nullable = false)
	private String email;


	@Column(name = "telephone", nullable = false)
	private String telephone;


	@Column(name = "classe", nullable = false)
	private String classe;

	@Column(name = "status", nullable = false)
	private String status;
	

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getStatus() {
		return this.status.toLowerCase();
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return this.geidentification() + ", " + this.email + ", " + this.telephone + ", status: " + this.status;
	}


	public String geidentification() {
		return this.name + "/" + this.id;
	}

}
