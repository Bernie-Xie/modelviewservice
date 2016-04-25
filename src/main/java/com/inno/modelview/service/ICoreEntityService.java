package com.inno.modelview.service;

import java.util.List;

import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.DTO.EntityDTO;

public interface ICoreEntityService {
	
	public List<EntityDTO> getAllEntities();
	
	public CoreEntity getCoreEntityById(int id);

	public CoreEntity getCoreEntityByName(String name);

	public void saveCoreEntity(CoreEntity coreEntity);
	
	public List<CoreEntity> getAllParentEntites(CoreEntity coreEntity);

}
