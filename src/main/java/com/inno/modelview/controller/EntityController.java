package com.inno.modelview.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inno.modelview.model.DTO.EntityColumnDTO;
import com.inno.modelview.model.DTO.EntityDTO;
import com.inno.modelview.model.EntityColumn;
import com.inno.modelview.service.IEntityColumnService;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.service.ICoreEntityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EntityController {
	
	@Autowired
	ICoreEntityService coreEntityService;
	@Autowired
	IEntityColumnService entityColumnService;

	/**
	 * The response is get available entities.
	 */
	@RequestMapping("/entities")
	public ResponseEntity<List<EntityDTO>> getEntities(){
		List<EntityDTO> entityDTOs = coreEntityService.getAllEntities();
		if (entityDTOs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(entityDTOs, HttpStatus.OK);
	}

	/**
	 * The response is get entity by its name
	 */
	@RequestMapping(value="/entity/{name}", method=RequestMethod.GET)
	public ResponseEntity<CoreEntity> getEntityByName(@PathVariable String name){
		CoreEntity coreEntity = coreEntityService.getCoreEntityByName(name);
		if (coreEntity==null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(coreEntity, HttpStatus.OK);
	}

	/**
	 * Save entity
	 */
	@RequestMapping(value="/entity", method=RequestMethod.POST)
	public ResponseEntity saveEntity(@RequestBody CoreEntity coreEntity){
		Integer gId = 0;
		try {
			gId = coreEntityService.saveCoreEntity(coreEntity);
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(gId, HttpStatus.CREATED);
	}

	/**
	 * The response is to return parent core entity (List) in terms of coreEntity
	 */
	@RequestMapping("/entity/parentes")
	public ResponseEntity<List<CoreEntity>> getParentEntities(CoreEntity coreEntity){
		List<CoreEntity> coreEntities = coreEntityService.getAllParentEntites(coreEntity);
		if (coreEntities.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(coreEntities, HttpStatus.OK);
	}

	/**
	 * The response is to return EntityColumns (List) in terms of the EntityID
	 */
	@RequestMapping(value="/entitycolumn/{entityId}", method=RequestMethod.GET)
	public ResponseEntity<List<EntityColumn>> getEntityColumnsByEntityId(@PathVariable Integer entityId){
		List<EntityColumn> entityColumns =  entityColumnService.getEntityColumnsByEntityId(entityId);
		if (entityColumns.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(entityColumns, HttpStatus.OK);
	}

	/**
	 * Save entity columns
	 */
	@RequestMapping(value="/entitycolumn", method=RequestMethod.POST)
	public ResponseEntity saveEntityColumn(@RequestBody List<EntityColumnDTO> entityColumnDTOs){
		if (entityColumnDTOs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		ObjectMapper mapper = new ObjectMapper();
		List<EntityColumnDTO> entityColumnDTOList = mapper.convertValue(entityColumnDTOs, new TypeReference<List<EntityColumnDTO>>(){});
		try {
			if (entityColumnDTOList.size() > 0) {
				int coreEntityId = entityColumnDTOList.get(0).getCoreEntity_Id();
				CoreEntity coreEntity = coreEntityService.getCoreEntityById(coreEntityId);
				entityColumnDTOList.forEach(e -> {
					EntityColumn entityColumn = new EntityColumn(coreEntity,
							e.getForeignKey_Id() == null ? null : coreEntityService.getCoreEntityById(e.getForeignKey_Id()),
							e.getDescription(),
							e.getName(),
							e.getEntityType(),
							true);
					Integer id = entityColumnService.saveEntityColumnsByEntity(entityColumn);
				});
			}
		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	//TODO Add Update
}
