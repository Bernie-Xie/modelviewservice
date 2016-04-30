package com.inno.modelview.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inno.modelview.model.DTO.TopicDTO;
import com.inno.modelview.model.DTO.TopicStepDTO;
import com.inno.modelview.model.TopicStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.inno.modelview.model.Topic;
import com.inno.modelview.service.ITopicStepService;
import com.inno.modelview.service.ITopicService;

import java.util.List;

@Controller
public class TopicController {

	@Autowired
	ITopicService topicService;

	@Autowired
	ITopicStepService topicStepService;
	
	@RequestMapping(value="/topics", method=RequestMethod.GET)
	public ResponseEntity<List<TopicDTO>> getTopics(){
		List<TopicDTO> topicDTOs = topicService.getAllTopics();
		if (topicDTOs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(topicDTOs, HttpStatus.OK);
	}

	/**
	 * The response is get topic by its name (URL: how_to_use_go)
	 */
	@RequestMapping(value="/topic/{name}", method=RequestMethod.GET)
	public ResponseEntity<Topic> getTopicByName(@PathVariable String name){
		Topic topic = topicService.getTopicByName(name);
		if (topic==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(topic, HttpStatus.OK);
	}

	/**
	 * Save topic.
	 */
	@RequestMapping(value="/topic", method=RequestMethod.POST)
	public ResponseEntity saveTopic(@RequestBody Topic topic){
		Integer gId = 0;
		try {
			gId = topicService.saveTopic(topic);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(gId, HttpStatus.CREATED);
	}

	/**
	 * The response is to return Topic steps (List) in terms of the TopicID
	 */
	@RequestMapping(value="/topicstep/{topicId}", method=RequestMethod.GET)
	public ResponseEntity<List<TopicStep>> getStepsByTopicId(@PathVariable Integer topicId){
		List<TopicStep> topicSteps =  topicStepService.getStepsByTopicId(topicId);
		if (topicSteps.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(topicSteps, HttpStatus.OK);
	}


	/**
	 * Save topic steps
	 */
	@RequestMapping(value="/topicstep", method=RequestMethod.POST)
	public ResponseEntity saveEntityColumn(@RequestBody List<TopicStepDTO> topicStepDTOs){
		if (topicStepDTOs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		ObjectMapper mapper = new ObjectMapper();
		List<TopicStepDTO> topicStepDTOList = mapper.convertValue(topicStepDTOs, new TypeReference<List<TopicStepDTO>>(){});
		try {
			if (topicStepDTOList.size() > 0) {
				int topicId = topicStepDTOList.get(0).getTopic_Id();
				Topic topic = topicService.getTopicById(topicId);
				topicStepDTOList.forEach(e -> {
					TopicStep topicStep = new TopicStep(
							topic,
							e.getStepId(),
							e.getShortDescription(),
							e.getDescription(),
							e.getScreenShotUrl());
					Integer id = topicStepService.saveTopicStep(topicStep);
				});
			}
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
