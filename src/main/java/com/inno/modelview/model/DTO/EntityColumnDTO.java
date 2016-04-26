package com.inno.modelview.model.DTO;


/**
 * EntityColumnDTO is to transfer entityColumns
 */
public class EntityColumnDTO {

    public EntityColumnDTO() { }

    public EntityColumnDTO(Integer coreEntity_Id, Integer foreignKey_Id, String description, String name, String entityType) {
        this.coreEntity_Id = coreEntity_Id;
        this.foreignKey_Id = foreignKey_Id;
        this.description = description;
        this.name = name;
        this.entityType = entityType;
    }

    private String description;
    private String name;
    private String entityType;
    private Integer coreEntity_Id;
    private Integer foreignKey_Id;

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

    public Integer getCoreEntity_Id() {
        return coreEntity_Id;
    }

    public void setCoreEntity_Id(Integer coreEntity_Id) {
        this.coreEntity_Id = coreEntity_Id;
    }

    public Integer getForeignKey_Id() {
        return foreignKey_Id;
    }

    public void setForeignKey_Id(Integer foreignKey_Id) {
        this.foreignKey_Id = foreignKey_Id;
    }
}
