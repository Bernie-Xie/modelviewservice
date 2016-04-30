package com.inno.modelview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inno.modelview.model.TopicStep;
import com.inno.modelview.dao.ITopicStepDao;
import com.inno.modelview.model.Topic;
import com.inno.modelview.service.ITopicStepService;

import java.util.List;

@Service
public class TopicTopicStepService implements ITopicStepService {

	@Autowired
	ITopicStepDao topicStepDao;
	
	public List<TopicStep> getStepsByTopic(Topic topic){
		return topicStepDao.getStepsByTopic(topic);
	}

	@Override
	public List<TopicStep> getStepsByTopicId(Integer topicId) {
		return topicStepDao.getStepsByTopicId(topicId);
	}

	public TopicStep getStepById(String id){
		return topicStepDao.getStepById(id);
	}

	@Override
	public Integer saveTopicStep(TopicStep topicStep) {
		return topicStepDao.saveTopicStep(topicStep);
	}
}
