package com.inno.modelview.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inno.modelview.dao.ITopicDao;
import com.inno.modelview.model.Topic;

@Repository
public class TopicDao extends BaseDao<Topic> implements ITopicDao {	
	
	public List<Topic> getAllTopics(){
		return (List<Topic>) this.getHibernateTemplate().find("FROM Topic");
	}
	
	public Topic getTopicById(Topic topic){
		List<Topic> topics = (List<Topic>) this.getHibernateTemplate().find("FROM Topic where id =?", new Object[]{topic.getId()});
		if(topics.size() > 0){
			return topics.get(0);
		}else{
			return null;
		}
	}
	
}
