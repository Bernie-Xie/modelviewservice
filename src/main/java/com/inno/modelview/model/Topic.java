package com.inno.modelview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	private String description;
	
	private String keywards;
	
	public int getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public String getKeywards() {
		return keywards;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setKeywards(String keywards) {
		this.keywards = keywards;
	}
	
	
	
}
