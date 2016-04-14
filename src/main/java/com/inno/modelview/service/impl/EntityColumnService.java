package com.inno.modelview.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.inno.modelview.dao.impl.EntityColumnDao;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;

public class EntityColumnService {

	@Resource
	EntityColumnDao entityColumnDao;
	
	public List<EntityColumn> getEntityColumnsByEntity(CoreEntity coreEntity){
		return entityColumnDao.getEntityColumnsByEntity(coreEntity);
	}
	
}
