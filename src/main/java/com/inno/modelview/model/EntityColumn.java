package com.inno.modelview.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EntityColumn {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="owner")
	private CoreEntity owner;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="foreignKey")
	private CoreEntity foreignKey;
	
	private String description;
	
	private String name;
	
	private String entityType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CoreEntity getOwner() {
		return owner;
	}
	public void setOwner(CoreEntity owner) {
		this.owner = owner;
	}
	public CoreEntity getForeignKey() {
		return foreignKey;
	}
	public void setForeignKey(CoreEntity foreignKey) {
		this.foreignKey = foreignKey;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
}
