package com.inno.modelview.model;

public class MEntityField {
	
    private String fieldName;
    private String fieldType;
    private String fieldDesc;
    
    public MEntityField() {}
    
    public MEntityField(String fieldName, String fieldType, String fieldDesc) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.fieldDesc = fieldDesc;
    }
    
    @Override
    public String toString() {
        return "EntityField{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldType='" + fieldType + '\'' +
                ", fieldDesc='" + fieldDesc + '\'' +
                '}';
    }

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldDesc() {
		return fieldDesc;
	}

	public void setFieldDesc(String fieldDesc) {
		this.fieldDesc = fieldDesc;
	}

}
