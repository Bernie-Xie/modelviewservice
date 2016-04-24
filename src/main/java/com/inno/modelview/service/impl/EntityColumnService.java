package com.inno.modelview.service.impl;

import java.util.List;

import com.inno.modelview.dao.IEntityColumnDao;
import com.inno.modelview.dao.impl.EntityColumnDao;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;
import com.inno.modelview.service.IEntityColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntityColumnService implements IEntityColumnService {

	@Autowired
	@Qualifier("OutMemoryEntityColumn")
	private IEntityColumnDao entityColumnDao;

	public List<EntityColumn> getEntityColumnsByEntity(CoreEntity coreEntity){
		return entityColumnDao.getEntityColumnsByEntity(coreEntity);
	}

	@Transactional(readOnly = false)
	public void saveEntityColumnsByEntity(EntityColumn entityColumn){
		entityColumnDao.saveEntityColumnsByEntity(entityColumn);
	}
	
}
