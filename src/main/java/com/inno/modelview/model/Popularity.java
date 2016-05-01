package com.inno.modelview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name="MV_POPULARITY")
public class Popularity {

    public Popularity() {}

    public Popularity(Integer views, Integer likes, ModelType modelType, int modelPublicId, boolean isActive) {
        this.views = views;
        this.likes = likes;
        this.modelType = modelType;
        this.modelPublicId = modelPublicId;
        this.isActive = isActive;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID")
    private int id;

    private Integer views;
    private Integer likes;

    @Column(nullable = false)
    private ModelType modelType;

    @Column(nullable = false)
    private int modelPublicId;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isActive = true;

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
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
        return "Popularity{" +
                ", views=" + views +
                ", likes=" + likes +
                ", modelType=" + modelType +
                ", modelPublicId=" + modelPublicId +
                '}';
    }
}
