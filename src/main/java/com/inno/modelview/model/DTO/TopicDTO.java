package com.inno.modelview.model.DTO;

/**
 * TopicDTO is to exposed to "All Topics" view layer
 */
public class TopicDTO {

    public TopicDTO() {}

    public TopicDTO(String title, String name, String description, Integer views, Integer likes, String createUserName) {
        this.title = title;
        this.name = name;
        this.description = description;
        this.views = views;
        this.likes = likes;
        this.createUserName = createUserName;
    }

    private String title;
    private String name;
    private String description;
    private Integer views;
    private Integer likes;
    private String createUserName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "TopicDTO{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", views=" + views +
                ", likes=" + likes +
                ", createUserName='" + createUserName + '\'' +
                '}';
    }
}
