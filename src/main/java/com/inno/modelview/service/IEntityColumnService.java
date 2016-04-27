package com.inno.modelview.service;

import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;

import java.util.List;

public interface IEntityColumnService {

    List<EntityColumn> getEntityColumnsByEntity(CoreEntity coreEntity);

    List<EntityColumn> getEntityColumnsByEntityId(Integer coreEntityId);

    Integer saveEntityColumnsByEntity(EntityColumn entityColumn);
}
