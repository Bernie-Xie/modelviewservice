package com.inno.modelview.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.inno.modelview.dao.IEntityColumnDao;
import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;

import javax.swing.text.html.parser.Entity;

@Repository
public class EntityColumnDao extends BaseDao<EntityColumn> implements IEntityColumnDao {

	public List<EntityColumn> getEntityColumnsByEntity(CoreEntity coreEntity){
		return (List<EntityColumn>) this.getHibernateTemplate().find("From EntityColumn where COREENTITY_ID = ?",new Object[]{coreEntity.getId()});
	}

	public List<EntityColumn> getEntityColumnsByEntityId(Integer id){
		List<EntityColumn> list = (List<EntityColumn>) this.getHibernateTemplate().find("From EntityColumn where COREENTITY_ID = ?", id);
		return list;
	}

	public void saveEntityColumnsByEntity(EntityColumn entityColumn) {
		save(entityColumn);
	}

	public EntityColumn getEntityColumnById(EntityColumn entityColumn){
		List<EntityColumn> entityColumns = (List<EntityColumn>) this.getHibernateTemplate().find("FROM EntityColumn where id = ?",new Object[]{entityColumn.getId()});
		if(entityColumns.size() > 0){
			return entityColumns.get(0);
		}
		return null;
	}

}
