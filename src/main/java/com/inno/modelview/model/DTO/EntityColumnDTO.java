package com.inno.modelview.model.DTO;

import com.inno.modelview.model.EntityColumn;

/**
 * EntityColumnDTO is to transfer entityColumns
 */
public class EntityColumnDTO {

    public EntityColumnDTO(Integer coreEntity_Id, Integer foreignKey, String description, String name, String entityType) {
        this.coreEntity_Id = coreEntity_Id;
        this.foreignKey = foreignKey;
        this.description = description;
        this.name = name;
        this.entityType = entityType;
    }

    public EntityColumnDTO(EntityColumn entityColumn) {
        this.entityColumn = entityColumn;
    }

    private EntityColumn entityColumn;
    private String description;
    private String name;
    private String entityType;
    private Integer coreEntity_Id;
    private Integer foreignKey;

    public String getDescription() {
        return entityColumn.getDescription();
    }

    public String getName() {
        return entityColumn.getName();
    }

    public String getEntityType() {
        return entityColumn.getEntityType();
    }

    public Integer getCoreEntity_Id() {
        return entityColumn.getOwner().getId();
    }

    public Integer getForeignKey() {
        return entityColumn.getForeignKey() == null? null : entityColumn.getForeignKey().getId();
    }

}
