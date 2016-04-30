package com.inno.modelview.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.inno.modelview.model.EntityColumn;
import com.inno.modelview.model.DTO.EntityDTO;
import com.inno.modelview.service.IEntityColumnService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
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

	public Session getSession() {
		return this.getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	//TODO Will user properties to save all SQLs
	//TODO Consider to use CACHE to cache the result
	public List<EntityDTO> getEnties(){
		List<EntityDTO> entityDTOs = new ArrayList<>();
		List metalist = getSession().createSQLQuery("select * from mv_coreentity e " +
				"left join mv_popularity p on e.id=p.MODELPUBLICID " +
				"left join mv_contributor c on e.id=c.MODELPUBLICID " +
				"where p.modeltype=0 and c.modeltype=0")
				.addScalar("entityName", StandardBasicTypes.STRING)
				.addScalar("views", StandardBasicTypes.INTEGER)
				.addScalar("likes", StandardBasicTypes.INTEGER)
				.addScalar("createUserName", StandardBasicTypes.STRING).list();
		for (Iterator iterator = metalist.iterator(); iterator.hasNext();) {
			Object[] objects = (Object[]) iterator.next();
			entityDTOs.add(new EntityDTO(
					objects[0].toString(), (int)objects[1], (int)objects[2], objects[3].toString()
			));
		}
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


	public Integer saveCoreEntity(CoreEntity coreEntity){
		return save(coreEntity);
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
