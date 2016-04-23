package com.inno.modelview.dao;

import java.util.List;
import com.inno.modelview.model.CoreEntity;

public interface ICoreEntityDao {
	
	public List<CoreEntity> getEnties();

	public void saveCoreEntity(CoreEntity coreEntity);
	
	public CoreEntity getCoreEntityById(String id);
	
	public CoreEntity getParentEntity(CoreEntity coreEntity);

}
