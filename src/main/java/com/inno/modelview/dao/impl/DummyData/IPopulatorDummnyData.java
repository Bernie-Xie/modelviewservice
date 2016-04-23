package com.inno.modelview.dao.impl.DummyData;

import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;

import java.util.List;
import java.util.Set;

interface IPopulatorDummnyData {

    Set<CoreEntity> populateEntites();

    Set<EntityColumn> populateEntityColumns(CoreEntity owner);
}
