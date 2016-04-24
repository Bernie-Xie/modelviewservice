package com.inno.modelview.model;

import javax.persistence.*;

@Entity
@Table(name="MV_Step")
public class Step {

	public Step(String shortDescription, String descroption, Topic topic, String screenShot) {
		this.shortDescription = shortDescription;
		this.descroption = descroption;
		this.topic = topic;
		this.screenShot = screenShot;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;


	private String shortDescription;
	
	private String descroption;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="owner")
	private Topic topic;
	
	private String screenShot;
	
	public int getId() {
		return id;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public String getDescroption() {
		return descroption;
	}
	public Topic getTopic() {
		return topic;
	}
	public String getScreenShot() {
		return screenShot;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public void setDescroption(String descroption) {
		this.descroption = descroption;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public void setScreenShot(String screenShot) {
		this.screenShot = screenShot;
	}
	
	
	
}
