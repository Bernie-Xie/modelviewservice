package com.inno.modelview.model.DTO;

/**
 * TopicStepDTO is to transfer topic steps
 */
public class TopicStepDTO {

    public TopicStepDTO() {}

    public TopicStepDTO(int stepId, String shortDescription, String description, String screenShotUrl, int topic_Id) {
        this.stepId = stepId;
        this.shortDescription = shortDescription;
        this.description = description;
        this.screenShotUrl = screenShotUrl;
        this.topic_Id = topic_Id;
    }

    private int stepId;
    private String shortDescription;
    private String description;
    private String screenShotUrl;
    private int topic_Id;

    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScreenShotUrl() {
        return screenShotUrl;
    }

    public void setScreenShotUrl(String screenShotUrl) {
        this.screenShotUrl = screenShotUrl;
    }

    public int getTopic_Id() {
        return topic_Id;
    }

    public void setTopic_Id(int topic_Id) {
        this.topic_Id = topic_Id;
    }

    @Override
    public String toString() {
        return "TopicStepDTO{" +
                "stepId=" + stepId +
                ", shortDescription='" + shortDescription + '\'' +
                ", description='" + description + '\'' +
                ", screenShotUrl='" + screenShotUrl + '\'' +
                ", topic_Id=" + topic_Id +
                '}';
    }
}
