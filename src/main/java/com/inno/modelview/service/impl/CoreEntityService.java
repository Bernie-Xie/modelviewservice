package com.inno.modelview.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.inno.modelview.dao.impl.EntityColumnDao;
import com.inno.modelview.model.viewmodel.EntityVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.inno.modelview.dao.ICoreEntityDao;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.service.ICoreEntityService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoreEntityService implements ICoreEntityService {

	@Autowired
	@Qualifier("OutMemory")
	private ICoreEntityDao coreEntityDao;

	public List<EntityVM> getAllEntities(){
		return coreEntityDao.getEnties();
	}

	@Transactional(readOnly = false)
	public void saveCoreEntity(CoreEntity coreEntity) {
		coreEntityDao.saveCoreEntity(coreEntity);
	}
	
	public CoreEntity getCoreEntityById(String id){
		return coreEntityDao.getCoreEntityById(id);
	}

	@Override
	public CoreEntity getCoreEntityByName(String name) {
		return coreEntityDao.getCoreEntityByName(name);
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