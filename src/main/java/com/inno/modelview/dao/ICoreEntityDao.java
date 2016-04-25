package com.inno.modelview.dao;

import java.util.List;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.DTO.EntityDTO;

public interface ICoreEntityDao {
	
	public List<EntityDTO> getEnties();

	public void saveCoreEntity(CoreEntity coreEntity);
	
	public CoreEntity getCoreEntityById(int id);

	public CoreEntity getCoreEntityByName(String name);
	
	public CoreEntity getParentEntity(CoreEntity coreEntity);

}
