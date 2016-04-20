package com.inno.modelview.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inno.modelview.dao.ICoreEntityDao;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.service.ICoreEntityService;

@Service
public class CoreEntityService implements ICoreEntityService {

	@Autowired
	@Qualifier("InMemory")
	private ICoreEntityDao coreEntityDao;
	
	public List<CoreEntity> getAllEntities(){
		return coreEntityDao.getEnties();
	}
	
	public CoreEntity getCoreEntityById(String id){
		return coreEntityDao.getCoreEntityById(id);
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