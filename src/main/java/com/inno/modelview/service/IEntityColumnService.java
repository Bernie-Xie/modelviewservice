package com.inno.modelview.service;

import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;

import java.util.List;

public interface IEntityColumnService {

    public List<EntityColumn> getEntityColumnsByEntity(CoreEntity coreEntity);

    public List<EntityColumn> getEntityColumnsByEntityId(Integer id);

    public void saveEntityColumnsByEntity(EntityColumn entityColumn);
}
