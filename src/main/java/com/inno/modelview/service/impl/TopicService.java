package com.inno.modelview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inno.modelview.dao.ITopicDao;
import com.inno.modelview.model.Topic;
import com.inno.modelview.model.DTO.TopicDTO;
import com.inno.modelview.service.ITopicService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TopicService implements ITopicService {

	@Autowired
	ITopicDao topicDao;

	@Override
	public Topic getTopicById(int id) {
		return topicDao.getTopicById(id);
	}

	@Override
	public Topic getTopicByName(String name) {
		return topicDao.getTopicByName(name);
	}

	@Transactional
	public List<TopicDTO> getAllTopics(){
		return topicDao.getAllTopics();
	}

	@Override
	@Transactional(readOnly = false)
	public Integer saveTopic(Topic topic) {
		return topicDao.saveTopic(topic);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateTopic(Topic topic) {
		topicDao.updateTopic(topic);
	}

}
