package com.inno.modelview.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.service.ICoreEntityService;

@Controller
public class EntityController {
	
	@Resource
	ICoreEntityService coreEntityService;
	
/*	
	@Resource
	EntityService entityService;

	@RequestMapping(value="/c", method=RequestMethod.POST)  
    public String createEntity(@ModelAttribute("entity") MEntity entity) { 		
		entityService.saveEntity(entity);
		return "sucess";
    } */
	
	/*@RequestMapping(value="/r/{name}", method=RequestMethod.GET)  
    public @ResponseBody Object queryEntity(@PathVariable String name) { 		
		MEntity entity = entityService.findEntityByName("");
		return new EntityViewModel(entity, null);
    } */

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
	
	@RequestMapping("/entity/parentes")
	@ResponseBody
	public Object getParentEntities(CoreEntity coreEntity){
		return coreEntityService.getAllParentEntites(coreEntity);
	}	
	
	
	
}
