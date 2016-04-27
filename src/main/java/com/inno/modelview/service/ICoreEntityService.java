package com.inno.modelview.service;

import java.util.List;

import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.DTO.EntityDTO;

public interface ICoreEntityService {
	
	List<EntityDTO> getAllEntities();
	
	CoreEntity getCoreEntityById(int id);

	CoreEntity getCoreEntityByName(String name);

	Integer saveCoreEntity(CoreEntity coreEntity);
	
	List<CoreEntity> getAllParentEntites(CoreEntity coreEntity);

}
