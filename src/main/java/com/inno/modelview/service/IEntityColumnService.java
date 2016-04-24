package com.inno.modelview.service;

import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;

import java.util.List;

public interface IEntityColumnService {

    public List<EntityColumn> getEntityColumnsByEntity(CoreEntity coreEntity);

    public void saveEntityColumnsByEntity(EntityColumn entityColumn);
}
