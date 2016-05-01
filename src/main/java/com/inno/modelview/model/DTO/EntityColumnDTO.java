package com.inno.modelview.model.DTO;


/**
 * EntityColumnDTO is to transfer entityColumns
 */
public class EntityColumnDTO {

    public EntityColumnDTO() { }

    public EntityColumnDTO(String columnDescription, String columnName, String columnType, Integer coreEntity_Id, Integer foreignKey_Id) {
        this.columnDescription = columnDescription;
        this.columnName = columnName;
        this.columnType = columnType;
        this.coreEntity_Id = coreEntity_Id;
        this.foreignKey_Id = foreignKey_Id;
    }

    private String columnDescription;
    private String columnName;
    private String columnType;
    private Integer coreEntity_Id;
    private Integer foreignKey_Id;

    public String getColumnDescription() {
        return columnDescription;
    }

    public void setColumnDescription(String columnDescription) {
        this.columnDescription = columnDescription;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
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
