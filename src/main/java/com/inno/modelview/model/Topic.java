package com.inno.modelview.model;

import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@Table(name="MV_Topic")
public class Topic {

	public Topic(String name, String description) {
		this.description = description;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(length = 5000)
	private String description;

	@Column(length = 255)
	private String name;
	
	public int getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
