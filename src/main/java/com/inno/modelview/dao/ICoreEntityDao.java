package com.inno.modelview.dao;

import java.util.List;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.viewmodel.EntityVM;

public interface ICoreEntityDao {
	
	public List<EntityVM> getEnties();

	public void saveCoreEntity(CoreEntity coreEntity);
	
	public CoreEntity getCoreEntityById(String id);

	public CoreEntity getCoreEntityByName(String name);
	
	public CoreEntity getParentEntity(CoreEntity coreEntity);

}
