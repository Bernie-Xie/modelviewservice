package com.inno.modelview.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.inno.modelview.model.Topic;
import com.inno.modelview.service.IStepService;
import com.inno.modelview.service.ITopicService;

@Controller
public class TopicController {

	@Resource
	ITopicService topicService;
	
	@Resource
	IStepService stepService;
	
	@RequestMapping("/topics")
	@ResponseBody
	public Object getTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping(value="/topic/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Object getStepById(@PathVariable String id){
		return stepService.getStepById(id);
	}
	
	@RequestMapping("topic/allSteps")
	@ResponseBody
	public Object getStepsByTopic(Topic topic){
		return stepService.getStepsByTopic(topic);
	}
}
