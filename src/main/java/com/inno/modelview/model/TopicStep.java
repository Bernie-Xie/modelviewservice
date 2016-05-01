package com.inno.modelview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name="MV_TopicStep")
public class TopicStep {

	public TopicStep() {}

	public TopicStep(Topic topic, int stepId, String shortDescription, String description, String screenShotUrl, boolean isActive) {
		this.topic = topic;
		this.stepId = stepId;
		this.shortDescription = shortDescription;
		this.description = description;
		this.screenShotUrl = screenShotUrl;
		this.isActive = isActive;
	}

	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	private int stepId;

	private String shortDescription;
	
	private String description;

	@JsonIgnore
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="topic_id", nullable = false)
	private Topic topic;
	
	private String screenShotUrl;

	@JsonIgnore
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isActive = true;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getScreenShotUrl() {
		return screenShotUrl;
	}

	public void setScreenShotUrl(String screenShotUrl) {
		this.screenShotUrl = screenShotUrl;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}
