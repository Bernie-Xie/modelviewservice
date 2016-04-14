package com.inno.modelview.dao;

import java.util.List;
import com.inno.modelview.model.Topic;

public interface ITopicDao {
	
	public List<Topic> getAllTopics();
	
	public Topic getTopicById(Topic topic);

}
