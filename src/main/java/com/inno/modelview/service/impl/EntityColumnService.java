package com.inno.modelview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inno.modelview.dao.impl.EntityColumnDao;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;

public class EntityColumnService {

	@Autowired
	EntityColumnDao entityColumnDao;
	
	public List<EntityColumn> getEntityColumnsByEntity(CoreEntity coreEntity){
		return entityColumnDao.getEntityColumnsByEntity(coreEntity);
	}
	
}
