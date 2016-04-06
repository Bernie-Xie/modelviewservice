package com.inno.modelview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inno.modelview.dao.EntityDAO;
import com.inno.modelview.model.MEntity;
import com.inno.modelview.service.EntityService;
import com.inno.modelview.viewmodel.EntityViewModel;

@Service("entityService")
public class EntityServiceImpl implements EntityService {
	
	@Autowired
	private EntityDAO entityDAO;

	public MEntity findEntityByName(String name) {
		return entityDAO.findEntityByName(name);
	}

	public void saveEntity(MEntity entity) {
	    entityDAO.saveEntity(entity);		
	}

	public void updateEntity(MEntity entity) {
		// TODO Auto-generated method stub
		
	}

	public void deleteEntityByName(String name) {
		// TODO Auto-generated method stub
		
	}

	public List<EntityViewModel> findAllEntitiesViewModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityDAO getEntityDAO() {
		return entityDAO;
	}

	public void setEntityDAO(EntityDAO entityDAO) {
		this.entityDAO = entityDAO;
	}

}
