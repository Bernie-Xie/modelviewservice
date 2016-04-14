package com.inno.modelview.service;

import java.util.List;

import com.inno.modelview.model.CoreEntity;

public interface ICoreEntityService {
	
	public List<CoreEntity> getAllEntities();
	
	public CoreEntity getCoreEntityById(String id);
	
	public List<CoreEntity> getAllParentEntites(CoreEntity coreEntity);

}
