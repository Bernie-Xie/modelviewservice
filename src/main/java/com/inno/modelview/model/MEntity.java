package com.inno.modelview.model;

import java.util.List;

public class MEntity {

    private Integer id;
	private String entityName;
	private String entityTable;
	private List<MEntityField> entityFields;
	private String bizView;
	private String entityPath;
	private String entityMock;
	private String entitiesRange;
	private String owner;
	
    public MEntity() {}	

	public MEntity(String entityName, String entityTable, List<MEntityField> entityFields, String bizView,
			      String entityPath, String entityMock, String entitiesRange, String owner) {
		this.entityName = entityName;
		this.entityTable = entityTable;
		this.entityFields = entityFields;
		this.bizView = bizView;
		this.entityPath = entityPath;
		this.entityMock = entityMock;
		this.entitiesRange = entitiesRange;
		this.owner = owner;
	}
	
    @Override
    public String toString() {
        return "Entity{" +
                "entityName='" + entityName + '\'' +
                ", entityTable='" + entityTable + '\'' +
                ", entityFields=" + entityFields +
                ", bizView='" + bizView + '\'' +
                ", entityPath='" + entityPath + '\'' +
                ", entityMock='" + entityMock + '\'' +
                ", entitiesRange='" + entitiesRange + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
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

	public List<MEntityField> getEntityFields() {
		return entityFields;
	}

	public void setEntityFields(List<MEntityField> entityFields) {
		this.entityFields = entityFields;
	}

	public String getBizView() {
		return bizView;
	}

	public void setBizView(String bizView) {
		this.bizView = bizView;
	}

	public String getEntityPath() {
		return entityPath;
	}

	public void setEntityPath(String entityPath) {
		this.entityPath = entityPath;
	}

	public String getEntityMock() {
		return entityMock;
	}

	public void setEntityMock(String entityMock) {
		this.entityMock = entityMock;
	}

	public String getEntitiesRange() {
		return entitiesRange;
	}

	public void setEntitiesRange(String entitiesRange) {
		this.entitiesRange = entitiesRange;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
