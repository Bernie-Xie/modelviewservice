package com.inno.modelview.dao.impl;

import java.util.List;

import com.inno.modelview.dao.impl.DummyData.PopulatorDummyData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.inno.modelview.dao.ICoreEntityDao;
import com.inno.modelview.model.CoreEntity;

@Repository
@Component(value="InMemory")
public class CoreEntityMemRepo extends BaseDao<CoreEntity> implements ICoreEntityDao {

    private PopulatorDummyData _populator;

    public CoreEntityMemRepo() {
        if (_populator == null) {
            this._populator = new PopulatorDummyData();
        }
    }

    @Override
    public List<CoreEntity> getEnties(){
        return _populator.populateEntites();
    }

    @Override
    public void saveCoreEntity(CoreEntity coreEntity) {

    }

    @Override
    public CoreEntity getCoreEntityById(String id){

        return null;
    }

    @Override
    public CoreEntity getCoreEntityByName(String name) {
        return null;
    }

    @Override
    public CoreEntity getParentEntity(CoreEntity coreEntity){

        return null;
    }

}
