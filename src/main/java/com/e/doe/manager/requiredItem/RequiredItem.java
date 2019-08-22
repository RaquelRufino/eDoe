package com.e.doe.manager.requiredItem;


import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="tb_required_item")
@Entity
public class RequiredItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "amount", nullable = false)
	private int amount;
	
	@Column(name = "tags", nullable = false)
	private String[] tags;
	
	@Column(name = "idReceptor", nullable = false)
	private String idReceptor;
	
	@Column(name = "score")
	private int score;
	
	public String getIdReceptor() {
		return idReceptor;
	}

	public void setIdReceptor(String idReceptor) {
		this.idReceptor = idReceptor;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public RequiredItem() {

	}
	
	public RequiredItem(long id) {
		this();
		this.id = id;
	}
	
	public RequiredItem(String description, int amount, String [] tags, String idReceptor) {
	    this();
	    this.description = description.toLowerCase();
	    this.amount = amount;
	    this.tags = tags;
	    this.idReceptor = idReceptor;
	 }
	  
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

	public String getidReceptor() {
		return idReceptor;
	}

	
	public void setidReceptor(String idReceptor) {
		this.idReceptor = idReceptor;
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
