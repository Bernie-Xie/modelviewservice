package com.inno.modelview.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inno.modelview.dao.IStepDao;
import com.inno.modelview.dao.impl.StepDao;
import com.inno.modelview.model.Step;
import com.inno.modelview.model.Topic;
import com.inno.modelview.service.IStepService;

@Service
public class StepService implements IStepService {

	@Resource
	IStepDao stepDao;
	
	public List<Step> getStepsByTopic(Topic topic){
		return stepDao.getStepsByTopic(topic);
	}
	
	public Step getStepById(String id){
		return stepDao.getStepById(id);
	}
	
}
