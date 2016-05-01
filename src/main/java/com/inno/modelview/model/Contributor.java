package com.inno.modelview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name="MV_CONTRIBUTOR")
public class Contributor {

    public Contributor() {}

    public Contributor(String createUserName, String lastModifiedUserName, ModelType modelType, int modelPublicId, boolean isActive) {
        this.createUserName = createUserName;
        this.lastModifiedUserName = lastModifiedUserName;
        this.modelType = modelType;
        this.modelPublicId = modelPublicId;
        this.isActive = isActive;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private int id;

    private String createUserName;
    private String lastModifiedUserName;

    @Column(nullable = false)
    private ModelType modelType;

    @Column(nullable = false)
    private int modelPublicId;


    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isActive = true;

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getLastModifiedUserName() {
        return lastModifiedUserName;
    }

    public void setLastModifiedUserName(String lastModifiedUserName) {
        this.lastModifiedUserName = lastModifiedUserName;
    }

    public ModelType getModelType() {
        return modelType;
    }

    public void setModelType(ModelType modelType) {
        this.modelType = modelType;
    }

    public int getModelPublicId() {
        return modelPublicId;
    }

    public void setModelPublicId(int modelPublicId) {
        this.modelPublicId = modelPublicId;
    }

    @JsonIgnore
    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Contributor{" +
                ", createUserName='" + createUserName + '\'' +
                ", lastModifiedUserName='" + lastModifiedUserName + '\'' +
                ", modelType=" + modelType +
                ", modelPublicId=" + modelPublicId +
                '}';
    }
}
