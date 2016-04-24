package com.inno.modelview.dao;

import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;

import java.util.List;

public interface IEntityColumnDao {
    public List<EntityColumn> getEntityColumnsByEntity(CoreEntity coreEntity);

    public void saveEntityColumnsByEntity(EntityColumn entityColumn);

    public EntityColumn getEntityColumnById(EntityColumn entityColumn);
}
