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
public class CoreEntity {
	public CoreEntity(String entityName, String businessValue, String entityBuilder, CoreEntity parentEntity) {
		this.entityName = entityName;
		this.businessValue = businessValue;
		this.entityBuilder = entityBuilder;
		this.parentEntity = parentEntity;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	private String entityName;
	
	private String businessValue;
	
	private String entityBuilder;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="parentEntity")
	private CoreEntity parentEntity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getBusinessValue() {
		return businessValue;
	}
	public void setBusinessValue(String businessValue) {
		this.businessValue = businessValue;
	}
	public String getEntityBuilder() {
		return entityBuilder;
	}
	public void setEntityBuilder(String entityBuilder) {
		this.entityBuilder = entityBuilder;
	}
	public CoreEntity getParentEntity() {
		return parentEntity;
	}
	public void setParentEntity(CoreEntity parentEntity) {
		this.parentEntity = parentEntity;
	}
	
	
}

