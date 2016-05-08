package com.inno.modelview.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.inno.modelview.model.EntityColumn;
import com.inno.modelview.model.DTO.EntityDTO;
import com.inno.modelview.model.ModelType;
import com.inno.modelview.service.IEntityColumnService;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.inno.modelview.dao.ICoreEntityDao;
import com.inno.modelview.model.CoreEntity;


@Repository
@Component(value="OutMemory")
public class CoreEntityDao extends BaseDao<CoreEntity> implements ICoreEntityDao {

	@Autowired
	IEntityColumnService entityColumnService;

	//TODO Will user properties to save all SQLs
	//TODO Consider to use CACHE to cache the result
	public List<EntityDTO> getEnties(){
		List<EntityDTO> entityDTOs = new ArrayList<>();
		List metaList = super.getSession().createSQLQuery("SELECT DISTINCT e.entityName, p.views, p.likes, c.createUserName FROM mv_coreentity e " +
				"LEFT JOIN mv_popularity p ON e.id=p.MODELPUBLICID AND p.modeltype=:pModeltype " +
				"LEFT JOIN mv_contributor c ON e.id=c.MODELPUBLICID AND c.modeltype=:cModeltype " +
				"WHERE e.status=0")
				.addScalar("entityName", StandardBasicTypes.STRING)
				.addScalar("views", StandardBasicTypes.INTEGER)
				.addScalar("likes", StandardBasicTypes.INTEGER)
				.addScalar("createUserName", StandardBasicTypes.STRING)
				.setInteger("pModeltype", ModelType.ENTITY.getValue())
				.setInteger("cModeltype", ModelType.ENTITY.getValue())
				.list();
		for (Iterator iterator = metaList.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			entityDTOs.add(new EntityDTO(
					objects[0] == null ? "" : objects[0].toString(),	//entityName
					objects[1] == null ? 0 : (Integer)objects[1],		//views
					objects[2] == null ? 0 : (Integer)objects[2],		//likes
					objects[3] == null ? "" : objects[3].toString()		//createUserName
			));
		}
		return entityDTOs;
	}
	
	public CoreEntity getCoreEntityById(int id){
		List<CoreEntity> coreEntities = (List<CoreEntity>) this.getHibernateTemplate().find("FROM CoreEntity where status=0 and id = ?",new Object[]{new Integer(id)});
		if(coreEntities.size() > 0){
			CoreEntity returnCoreEntity = coreEntities.get(0);
			returnCoreEntity = appendEntityColumns(returnCoreEntity);
			return appendExistEntities(returnCoreEntity);
		}
		return null;
	}

	@Override
	public CoreEntity getCoreEntityByName(String name) {
		List<CoreEntity> coreEntities = (List<CoreEntity>) this.getHibernateTemplate().find("FROM CoreEntity where status=0 and entityname = ?", name);
		if(coreEntities.size() > 0){
			CoreEntity returnCoreEntity = coreEntities.get(0);
			returnCoreEntity = appendEntityColumns(returnCoreEntity);
			return appendExistEntities(returnCoreEntity);
		}
		return null;
	}


	public Integer saveCoreEntity(CoreEntity coreEntity){
		return save(coreEntity);
	}
	
	public CoreEntity getParentEntity(CoreEntity coreEntity){
		List<CoreEntity> coreEntities = (List<CoreEntity>) this.getHibernateTemplate().find("FROM CoreEntity where status=0 and parentEntity = ?",new Object[]{coreEntity.getParentEntity().getId()});
		if(coreEntities.size() > 0){
			return coreEntities.get(0);
		}
		return null;
	}

	private CoreEntity appendEntityColumns(CoreEntity coreEntity) {
		List<EntityColumn> entityColumns = entityColumnService.getEntityColumnsByEntity(coreEntity);
		coreEntity.setEntityColumns(entityColumns);
		return coreEntity;
	}

	private CoreEntity appendExistEntities(CoreEntity coreEntity) {
		List metaList = super.getSession().createSQLQuery("SELECT entityName FROM mv_coreentity e WHERE status=0")
				.addScalar("entityName").list();
		StringBuffer existEntitiesBuffer = new StringBuffer();
		metaList.forEach(e-> existEntitiesBuffer.append(e.toString()+","));
		coreEntity.setExistEntities(existEntitiesBuffer.toString());
		return coreEntity;
	}
}
