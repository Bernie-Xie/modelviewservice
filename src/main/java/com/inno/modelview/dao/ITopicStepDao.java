package com.inno.modelview.dao;

import java.util.List;
import com.inno.modelview.model.TopicStep;
import com.inno.modelview.model.Topic;

public interface ITopicStepDao {
	
	TopicStep getStepById(String id);
	
	List<TopicStep> getStepsByTopic(Topic topic);

	List<TopicStep> getStepsByTopicId(Integer topicId);

	Integer saveTopicStep(TopicStep topicStep);

}
