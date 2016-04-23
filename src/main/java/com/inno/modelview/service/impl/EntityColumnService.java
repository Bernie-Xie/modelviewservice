package com.inno.modelview.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.inno.modelview.dao.impl.EntityColumnDao;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EntityColumnService {

	@Autowired
	@Qualifier("OutMemory")
	EntityColumnDao entityColumnDao;
	
	public List<EntityColumn> getEntityColumnsByEntity(CoreEntity coreEntity){
		return entityColumnDao.getEntityColumnsByEntity(coreEntity);
	}

	public void saveEntityColumnsByEntity(EntityColumn entityColumn){
		entityColumnDao.saveEntityColumnsByEntity(entityColumn);
	}
	
}
