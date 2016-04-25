package com.inno.modelview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MV_COREENTITY")
public class CoreEntity {

	public CoreEntity() {}

	public CoreEntity(String entityName, String businessValue, String entityBuilder, CoreEntity parentEntity) {
		this.entityName = entityName;
		this.businessValue = businessValue;
		this.entityBuilder = entityBuilder;
		this.parentEntity = parentEntity;
	}

	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;

	@Column(length = 255)
	private String entityName;

	@Column(length = 5000)
	private String businessValue;

	@Column(length = 5000)
	private String entityBuilder;

	@OneToMany
	@JoinColumn(name="coreentity_id")
	private List<EntityColumn> entityColumns = new ArrayList<>();

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="parentEntity")
	private CoreEntity parentEntity;

	@OneToMany(mappedBy="CoreEntity",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<EntityColumn> getEntityColumns() {
		return entityColumns;
	}

	public void setEntityColumns(List<EntityColumn> entityColumns) {
		this.entityColumns = entityColumns;
	}

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

