package com.inno.modelview.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.inno.modelview.model.EntityColumn;
import com.inno.modelview.model.DTO.EntityDTO;
import com.inno.modelview.service.IEntityColumnService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.inno.modelview.dao.ICoreEntityDao;
import com.inno.modelview.model.CoreEntity;

import javax.annotation.Resource;

@Repository
@Component(value="OutMemory")
public class CoreEntityDao extends BaseDao<CoreEntity> implements ICoreEntityDao {

	@Resource
	IEntityColumnService entityColumnService;

	//TODO will update with Popularity and Contributor
	public List<EntityDTO> getEnties(){
		List<EntityDTO> entityDTOs = new ArrayList<>();
		List<CoreEntity> coreEntities = (List<CoreEntity>) this.getHibernateTemplate().find("FROM CoreEntity");
		coreEntities.forEach(e->entityDTOs.add(new EntityDTO(
				e.getEntityName(),
				0,
				0,
				"Will"
		)));
		return entityDTOs;
	}
	
	public CoreEntity getCoreEntityById(int id){
		List<CoreEntity> coreEntities = (List<CoreEntity>) this.getHibernateTemplate().find("FROM CoreEntity where id = ?",new Object[]{new Integer(id)});
		if(coreEntities.size() > 0){
			CoreEntity returnCoreEntity = coreEntities.get(0);
			return appendEntityColumns(returnCoreEntity);
		}
		return null;
	}

	@Override
	public CoreEntity getCoreEntityByName(String name) {
		List<CoreEntity> coreEntities = (List<CoreEntity>) this.getHibernateTemplate().find("FROM CoreEntity where entityname = ?", name);
		if(coreEntities.size() > 0){
			CoreEntity returnCoreEntity = coreEntities.get(0);
			return appendEntityColumns(returnCoreEntity);
		}
		return null;
	}


	public void saveCoreEntity(CoreEntity coreEntity){
		save(coreEntity);
	}
	
	public CoreEntity getParentEntity(CoreEntity coreEntity){
		List<CoreEntity> coreEntities = (List<CoreEntity>) this.getHibernateTemplate().find("FROM CoreEntity where parentEntity = ?",new Object[]{coreEntity.getParentEntity().getId()});
		if(coreEntities.size() > 0){
			return coreEntities.get(0);
		}
		return null;
	}

	private CoreEntity appendEntityColumns(CoreEntity coreEntity) {
		List<EntityColumn> entityColumns = entityColumnService.getEntityColumnsByEntityId(coreEntity.getId());
		coreEntity.setEntityColumns(entityColumns);
		return coreEntity;
	}
}
