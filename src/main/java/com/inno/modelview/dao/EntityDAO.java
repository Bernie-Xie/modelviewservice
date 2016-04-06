package com.inno.modelview.dao;

import java.util.List;

import com.inno.modelview.model.MEntity;
import com.inno.modelview.viewmodel.EntityViewModel;

public interface EntityDAO {
	
    MEntity findEntityByName(String name);

    void saveEntity(MEntity entity);

    void updateEntity(MEntity entity);

    void deleteEntityByName(String name);

    List<EntityViewModel> findAllEntitiesViewModel();

}
