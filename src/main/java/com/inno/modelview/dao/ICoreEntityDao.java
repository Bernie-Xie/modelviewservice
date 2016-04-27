package com.inno.modelview.dao;

import java.util.List;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.DTO.EntityDTO;

public interface ICoreEntityDao {
	
	List<EntityDTO> getEnties();

	Integer saveCoreEntity(CoreEntity coreEntity);
	
	CoreEntity getCoreEntityById(int id);

	CoreEntity getCoreEntityByName(String name);
	
	CoreEntity getParentEntity(CoreEntity coreEntity);

}
