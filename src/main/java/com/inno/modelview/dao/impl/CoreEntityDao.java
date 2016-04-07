package com.inno.modelview.dao.impl;

import java.util.List;

import com.inno.modelview.model.CoreEntity;

public class CoreEntityDao extends BaseDao<CoreEntity>{
	
	
	public List<CoreEntity> getEnties(){
		return (List<CoreEntity>) this.getHibernateTemplate().find("FROM CoreEntity");
	}
	
	public CoreEntity getCoreEntityById(CoreEntity coreEntity){
		List<CoreEntity> coreEntities = (List<CoreEntity>) this.getHibernateTemplate().find("FROM CoreEntity where id = ?",new Object[]{coreEntity.getId()});
		if(coreEntities.size() > 0){
			return coreEntities.get(0);
		}
		return null;
	}
	
	public CoreEntity getParentEntity(CoreEntity coreEntity){
		List<CoreEntity> coreEntities = (List<CoreEntity>) this.getHibernateTemplate().find("FROM CoreEntity where parentEntity = ?",new Object[]{coreEntity.getParentEntity().getId()});
		if(coreEntities.size() > 0){
			return coreEntities.get(0);
		}
		return null;
	}
}
