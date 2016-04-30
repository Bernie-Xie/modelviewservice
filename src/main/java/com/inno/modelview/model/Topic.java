package com.inno.modelview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MV_Topic")
public class Topic {

	public Topic() {}

	public Topic(String description, String name, String title) {
		this.description = description;
		this.name = name;
		this.title = title;
	}

	@JsonIgnore
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(length = 5000)
	private String description;

	@Column(length = 255)
	private String name;

	@Column(length = 255)
	private String title;

	@OneToMany
	@JoinColumn(name="topic_id")
	private List<TopicStep> topicSteps = new ArrayList<>();


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<TopicStep> getTopicSteps() {
		return topicSteps;
	}

	public void setTopicSteps(List<TopicStep> topicSteps) {
		this.topicSteps = topicSteps;
	}
}
