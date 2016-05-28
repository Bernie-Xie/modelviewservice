package com.inno.modelview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name="MV_TopicStep")
public class TopicStep {

	public TopicStep() {}

	public TopicStep(Topic topic, int stepId, String shortDescription, String description, String screenShotUrl) {
		this.topic = topic;
		this.stepId = stepId;
		this.shortDescription = shortDescription;
		this.description = description;
		this.screenShotUrl = screenShotUrl;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	private int stepId;

	private String shortDescription;
	
	private String description;


	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="topic_id", nullable = false)
	private Topic topic;
	
	private String screenShotUrl;


	@JsonIgnore
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

	@JsonIgnore
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

	@Override
	public String toString() {
		return "TopicStep{" +
				"id=" + id +
				", stepId=" + stepId +
				", shortDescription='" + shortDescription + '\'' +
				", description='" + description + '\'' +
				", topic=" + topic +
				", screenShotUrl='" + screenShotUrl + '\'' +
				'}';
	}
}
