package com.inno.modelview.service;

import java.util.List;

import com.inno.modelview.model.CoreEntity;

public interface ICoreEntityService {
	
	public List<CoreEntity> getAllEntities();
	
	public CoreEntity getCoreEntityById(String id);

	public CoreEntity getCoreEntityByName(String name);

	public void saveCoreEntity(CoreEntity coreEntity);
	
	public List<CoreEntity> getAllParentEntites(CoreEntity coreEntity);

}
