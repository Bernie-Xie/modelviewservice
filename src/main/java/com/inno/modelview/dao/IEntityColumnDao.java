package com.inno.modelview.dao;

import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;

import java.util.List;

public interface IEntityColumnDao {
    List<EntityColumn> getEntityColumnsByEntity(CoreEntity coreEntity);

    List<EntityColumn> getEntityColumnsByEntityId(Integer coreEntityId);

    Integer saveEntityColumnsByEntity(EntityColumn entityColumn);

    EntityColumn getEntityColumnById(Integer entityColumnId);
}
