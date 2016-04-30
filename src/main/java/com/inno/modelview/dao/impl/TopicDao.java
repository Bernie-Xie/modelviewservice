package com.inno.modelview.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.inno.modelview.model.ModelType;
import org.eclipse.jetty.util.StringUtil;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inno.modelview.model.DTO.TopicDTO;
import com.inno.modelview.model.TopicStep;
import com.inno.modelview.service.ITopicStepService;
import com.inno.modelview.dao.ITopicDao;
import com.inno.modelview.model.Topic;

@Repository
public class TopicDao extends BaseDao<Topic> implements ITopicDao {

	@Autowired
	ITopicStepService iTopicStepService;

	public List<TopicDTO> getAllTopics(){
		List<TopicDTO> topicDTOs = new ArrayList<>();
		List metaList = super.getSession().createSQLQuery("SELECT DISTINCT t.title, t.name, t.description, p.views, p.likes, c.createUserName FROM mv_topic t " +
				"LEFT JOIN mv_popularity p ON t.id=p.MODELPUBLICID AND p.modeltype = :pModelType " +
				"LEFT JOIN mv_contributor c ON t.id=c.MODELPUBLICID AND c.modeltype = :cModelType ")
				.addScalar("title", StandardBasicTypes.STRING)
				.addScalar("name", StandardBasicTypes.STRING)
				.addScalar("description", StandardBasicTypes.STRING)
				.addScalar("views", StandardBasicTypes.INTEGER)
				.addScalar("likes", StandardBasicTypes.INTEGER)
				.addScalar("createUserName", StandardBasicTypes.STRING)
				.setInteger("pModelType", ModelType.TOPIC.getValue())
				.setInteger("cModelType", ModelType.TOPIC.getValue())
				.list();
		for (Iterator iterator = metaList.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			topicDTOs.add(new TopicDTO(
					objects[0] == null ? "" : objects[0].toString(),	//title
					objects[1] == null ? "" : objects[1].toString(),	//name
					objects[2] == null ? "" : objects[2].toString(),	//description
					objects[3] == null ? 0 : (Integer)objects[3],		//views
					objects[4] == null ? 0 : (Integer)objects[4],		//likes
					objects[5] == null ? "" : objects[5].toString()		//createUserName
			));
		}
		return topicDTOs;
	}

	@Override
	public Topic getTopicById(int id) {
		List<Topic> topics = (List<Topic>) this.getHibernateTemplate().find("FROM Topic WHERE Id = ?", id);
		if(topics.size() > 0){
			Topic topic = topics.get(0);
			return appendTopicSteps(topic);
		}
		return null;
	}

	@Override
	public Topic getTopicByName(String name) {
		List<Topic> topics = (List<Topic>) this.getHibernateTemplate().find("FROM Topic WHERE name = ?", name);
		if(topics.size() > 0){
			Topic topic = topics.get(0);
			return appendTopicSteps(topic);
		}
		return null;
	}

	@Override
	public Integer saveTopic(Topic topic) {
		return save(topic);
	}

	private Topic appendTopicSteps(Topic topic) {
		List<TopicStep> topicSteps = iTopicStepService.getStepsByTopic(topic);
		topic.setTopicSteps(topicSteps);
		return topic;
	}

}
