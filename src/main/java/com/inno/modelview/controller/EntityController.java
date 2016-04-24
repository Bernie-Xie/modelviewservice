package com.inno.modelview.controller;

import javax.annotation.Resource;

import com.inno.modelview.dao.impl.DummyData.PopulatorDummyData;
import com.inno.modelview.model.EntityColumn;
import com.inno.modelview.service.IEntityColumnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.service.ICoreEntityService;

import java.util.List;

@Controller
public class EntityController {
	
	@Resource
	ICoreEntityService coreEntityService;

	@Resource
	IEntityColumnService entityColumnService;

	@RequestMapping("/entities")
	@ResponseBody
	public Object getEntities(){
		return coreEntityService.getAllEntities();
	}
	
	@RequestMapping(value="/entity/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Object getEntityById(@PathVariable String id){
		return coreEntityService.getCoreEntityById(id);
	}

	@RequestMapping(value="/entity/", method=RequestMethod.POST)
	@ResponseBody
	public void saveEntity(@RequestBody CoreEntity coreEntity){
		//CoreEntity coreEntity = new PopulatorDummyData().populateEntites().get(0);
		coreEntityService.saveCoreEntity(coreEntity);
		List<EntityColumn> list = new PopulatorDummyData().populateEntityColumns(coreEntity);
		list.forEach(e -> entityColumnService.saveEntityColumnsByEntity(e));
	}

	@RequestMapping("/entity/parentes")
	@ResponseBody
	public Object getParentEntities(CoreEntity coreEntity){
		return coreEntityService.getAllParentEntites(coreEntity);
	}	
	
	
	
}
