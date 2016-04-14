package com.inno.modelview.service;

import java.util.List;

import com.inno.modelview.model.Step;
import com.inno.modelview.model.Topic;

public interface IStepService {
	
	public List<Step> getStepsByTopic(Topic topic);
	
	public Step getStepById(String id);

}
