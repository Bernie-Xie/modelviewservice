package com.inno.modelview.service;

import java.util.List;
import com.inno.modelview.model.TopicStep;
import com.inno.modelview.model.Topic;

public interface ITopicStepService {

	TopicStep getStepById(String id);

	List<TopicStep> getStepsByTopic(Topic topic);

	List<TopicStep> getStepsByTopicId(Integer topicId);

	Integer saveTopicStep(TopicStep topicStep);

}
