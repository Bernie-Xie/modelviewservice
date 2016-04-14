package com.inno.modelview.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inno.modelview.dao.IStepDao;
import com.inno.modelview.model.Step;
import com.inno.modelview.model.Topic;

@Repository
public class StepDao extends BaseDao<Step> implements IStepDao {
	
	public Step getStepById(String id){
		List<Step> steps = (List<Step>) this.getHibernateTemplate().find("FROM Step where id = ?",new Object[]{new Integer(id)});
		if(steps.size() > 0){
			return steps.get(0);
		}else{
			return null;
		}
	}
	
	public List<Step> getStepsByTopic(Topic topic){
		List<Step> steps = (List<Step>) this.getHibernateTemplate().find("FROM Step where topic = ?",new Object[]{topic.getId()});
		return steps;
	}
	
}
