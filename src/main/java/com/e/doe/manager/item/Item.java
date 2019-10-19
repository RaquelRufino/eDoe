package com.e.doe.manager.item;

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
    public static final String CACHE_NAME = "Item";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "description", nullable = false)
	private String description;
	
	public String getDescription() {
		return description;
	}
		
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return this.getId() + " - " + this.getDescription();
	}
}
