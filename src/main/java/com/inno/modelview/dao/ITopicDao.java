package com.inno.modelview.dao;

import java.util.List;

import com.inno.modelview.model.DTO.TopicDTO;
import com.inno.modelview.model.Topic;

public interface ITopicDao {

	List<TopicDTO> getAllTopics();

	Topic getTopicById(int id);

	Topic getTopicByName(String name);

	Integer saveTopic(Topic topic);

}
