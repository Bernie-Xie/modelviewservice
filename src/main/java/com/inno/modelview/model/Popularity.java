package com.inno.modelview.model;

import javax.persistence.*;

@Entity
@Table(name="MV_POPULARITY")
public class Popularity {

    public Popularity() {}

    public Popularity(Integer views, Integer likes, ModelType modelType, int modelPublicId) {
        this.views = views;
        this.likes = likes;
        this.modelType = modelType;
        this.modelPublicId = modelPublicId;
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
