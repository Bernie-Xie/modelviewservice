package com.inno.modelview.dao.impl;

import java.util.List;

import com.inno.modelview.model.TopicStep;
import org.springframework.stereotype.Repository;

import com.inno.modelview.dao.ITopicStepDao;
import com.inno.modelview.model.Topic;

@Repository
public class TopicStepDao extends BaseDao<TopicStep> implements ITopicStepDao {
	
	public TopicStep getStepById(String id){
		List<TopicStep> topicSteps = (List<TopicStep>) this.getHibernateTemplate().find("FROM TopicStep where id = ?",new Object[]{new Integer(id)});
		if(topicSteps.size() > 0){
			return topicSteps.get(0);
		}else{
			return null;
		}
	}
	
	public List<TopicStep> getStepsByTopic(Topic topic){
		return getStepsByTopicId(topic.getId());
	}

	@Override
	public List<TopicStep> getStepsByTopicId(Integer topicId) {
		List<TopicStep> topicSteps = (List<TopicStep>) this.getHibernateTemplate().find("FROM TopicStep where topic_Id = ?", topicId);
		return topicSteps;
	}

	@Override
	public Integer saveTopicStep(TopicStep topicStep) {
		return save(topicStep);
	}

}
