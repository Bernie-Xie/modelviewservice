package com.inno.modelview.service;

import java.util.List;

import com.inno.modelview.model.Topic;

public interface ITopicService {
	
	public Topic getTopicById(Topic topic);
	
	public List<Topic> getAllTopics();

}
