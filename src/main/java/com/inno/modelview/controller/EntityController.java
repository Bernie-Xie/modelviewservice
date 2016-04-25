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

	/**
	 * The response is get available entities.
	 */
	@RequestMapping("/entities")
	@ResponseBody
	public Object getEntities(){
		return coreEntityService.getAllEntities();
	}

	/**
	 * The response is get entity by its name
	 */
	@RequestMapping(value="/entity/{name}", method=RequestMethod.GET)
	@ResponseBody
	public Object getEntityByName(@PathVariable String name){
		return coreEntityService.getCoreEntityByName(name);
	}

	/**
	 * The response is to mimic the POST.
	 */
	@RequestMapping(value="/entity", method=RequestMethod.POST)
	@ResponseBody
	public void saveEntity(@RequestBody CoreEntity coreEntity){
		coreEntityService.saveCoreEntity(coreEntity);
	}


	@RequestMapping("/entity/parentes")
	@ResponseBody
	public Object getParentEntities(CoreEntity coreEntity){
		return coreEntityService.getAllParentEntites(coreEntity);
	}

	/**
	 * The response is to return EntityColumns (List) in terms of the EntityID
	 */
	@RequestMapping(value="/entitycolumn/{entityId}", method=RequestMethod.GET)
	@ResponseBody
	public Object getEntityColumnByEntityName(@PathVariable Integer entityId){
		return entityColumnService.getEntityColumnsByEntityId(entityId);
	}


	/**
	 * The response is to POST the entity columns.
	 * TODO: Will be update soon
	 */
	@RequestMapping(value="/entitycolumn", method=RequestMethod.POST)
	@ResponseBody
	public void saveEntityColumn(@RequestBody List<EntityColumn> entityColumns){
		entityColumns.forEach(e -> entityColumnService.saveEntityColumnsByEntity(e));
	}
	
}
