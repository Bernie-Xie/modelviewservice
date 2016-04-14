package com.inno.modelview.dao;

import java.util.List;
import com.inno.modelview.model.Step;
import com.inno.modelview.model.Topic;

public interface IStepDao {
	
	public Step getStepById(String id);
	
	public List<Step> getStepsByTopic(Topic topic);

}
