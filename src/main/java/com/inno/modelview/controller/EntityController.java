package com.inno.modelview.controller;

import javax.annotation.Resource;

import com.inno.modelview.dao.impl.DummyData.PopulatorDummyData;
import com.inno.modelview.model.DTO.EntityColumnDTO;
import com.inno.modelview.model.DTO.EntityDTO;
import com.inno.modelview.model.EntityColumn;
import com.inno.modelview.service.IEntityColumnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.service.ICoreEntityService;

import java.util.ArrayList;
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
	public Object getEntityColumnsByEntityId(@PathVariable Integer entityId){
		List<EntityColumn> entityColumns =  entityColumnService.getEntityColumnsByEntityId(entityId);
		List<EntityColumnDTO> entityColumnDTOs = new ArrayList<>();
		entityColumns.forEach(e -> entityColumnDTOs.add(new EntityColumnDTO(e)));
		return entityColumnDTOs;
	}


	/**
	 * The response is to POST the entity columns.
	 */
	@RequestMapping(value="/entitycolumn", method=RequestMethod.POST)
	@ResponseBody
	public void saveEntityColumn(@RequestBody List<EntityColumnDTO> entityDTOs){
		if (entityDTOs.size() > 0) {
			int coreEntityId = entityDTOs.get(0).getCoreEntity_Id();
			CoreEntity coreEntity = coreEntityService.getCoreEntityById(coreEntityId);
			entityDTOs.forEach(e -> {
				EntityColumn entityColumn = new EntityColumn(coreEntity,
						e.getForeignKey()==null? null:coreEntityService.getCoreEntityById(e.getForeignKey()),
						e.getDescription(),
						e.getName(),
						e.getEntityType());
				entityColumnService.saveEntityColumnsByEntity(entityColumn);
			});
		}
	}
}
