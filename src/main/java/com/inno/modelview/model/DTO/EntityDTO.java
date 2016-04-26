package com.inno.modelview.model.DTO;

import com.inno.modelview.model.Contributor;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.Popularity;

/**
 * EntityDTO is to exposed to "All Entities" view layer
 */
public class EntityDTO {

    public EntityDTO() { }

    public EntityDTO(String entityName, Integer views, Integer likes, String createUserName) {
        this.entityName = entityName;
        this.views = views;
        this.likes = likes;
        this.createUserName = createUserName;
    }

    private String entityName;
    private Integer views;
    private Integer likes;
    private String createUserName;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

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

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }
}
