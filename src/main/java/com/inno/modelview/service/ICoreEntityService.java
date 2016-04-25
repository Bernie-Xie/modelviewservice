package com.inno.modelview.service;

import java.util.List;

import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.viewmodel.EntityVM;

public interface ICoreEntityService {
	
	public List<EntityVM> getAllEntities();
	
	public CoreEntity getCoreEntityById(String id);

	public CoreEntity getCoreEntityByName(String name);

	public void saveCoreEntity(CoreEntity coreEntity);
	
	public List<CoreEntity> getAllParentEntites(CoreEntity coreEntity);

}
