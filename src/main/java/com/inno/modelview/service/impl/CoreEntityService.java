package com.inno.modelview.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inno.modelview.dao.impl.CoreEntityDao;
import com.inno.modelview.model.CoreEntity;

@Service
public class CoreEntityService {

	@Autowired
	private CoreEntityDao coreEntityDao;
	
	public List<CoreEntity> getAllEntities(){
		return coreEntityDao.getEnties();
	}
	
	public CoreEntity getCoreEntityById(CoreEntity coreEntity){
		return coreEntityDao.getCoreEntityById(coreEntity);
	}
	
	public List<CoreEntity> getAllParentEntites(CoreEntity coreEntity){
		List<CoreEntity> parentEntites = new ArrayList<CoreEntity>();
		CoreEntity currentEntity = coreEntity;
		while(true){
			if(currentEntity.getParentEntity() == null){
				break;
			}
			CoreEntity parentEntity = coreEntityDao.getParentEntity(currentEntity);
			currentEntity = parentEntity;
			parentEntites.add(currentEntity);
		}
		return parentEntites;
	}
}