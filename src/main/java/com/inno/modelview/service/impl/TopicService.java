package com.inno.modelview.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inno.modelview.dao.ITopicDao;
import com.inno.modelview.dao.impl.TopicDao;
import com.inno.modelview.model.Topic;
import com.inno.modelview.service.ITopicService;

@Service
public class TopicService implements ITopicService {

	@Resource
	ITopicDao topicDao;
	
	public Topic getTopicById(Topic topic){
		return topicDao.getTopicById(topic);
	}
	
	public List<Topic> getAllTopics(){
		return topicDao.getAllTopics();
	}
	
}
