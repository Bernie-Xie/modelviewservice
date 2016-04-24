package com.inno.modelview.dao.impl.DummyData;

import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;

import java.util.List;

interface IPopulatorDummnyData {

    List<CoreEntity> populateEntites();

    List<EntityColumn> populateEntityColumns(CoreEntity owner);
}
