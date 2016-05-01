package com.inno.modelview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MV_COREENTITY")
public class CoreEntity {

	public CoreEntity() {}

	public CoreEntity(String entityName, String entityTable, String entityPath, String businessValue, String entityBuilder, CoreEntity parentEntity, boolean isActive) {
		this.entityName = entityName;
		this.entityTable = entityTable;
		this.entityPath = entityPath;
		this.businessValue = businessValue;
		this.entityBuilder = entityBuilder;
		this.parentEntity = parentEntity;
		this.isActive = isActive;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private int id;

	@Column(length = 255)
	private String entityName;

	@Column(length = 255)
	private String entityTable;

	@Column(length = 3000)
	private String entityPath;

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

	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isActive = true;

	@Transient
	private String existEntities;

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

	public String getEntityTable() {
		return entityTable;
	}

	public void setEntityTable(String entityTable) {
		this.entityTable = entityTable;
	}

	public String getEntityPath() {
		return entityPath;
	}

	public void setEntityPath(String entityPath) {
		this.entityPath = entityPath;
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

	@JsonIgnore
	public boolean isActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getExistEntities() {
		return existEntities;
	}

	public void setExistEntities(String existEntities) {
		this.existEntities = existEntities;
	}
}

