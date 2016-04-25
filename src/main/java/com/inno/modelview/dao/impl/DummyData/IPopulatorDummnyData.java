package com.inno.modelview.dao.impl.DummyData;

import com.inno.modelview.model.CoreEntity;
import com.inno.modelview.model.EntityColumn;
import com.inno.modelview.model.viewmodel.EntityVM;

import java.util.List;

interface IPopulatorDummnyData {

    List<EntityVM> populateEntites();

    List<EntityColumn> populateEntityColumns(CoreEntity owner);
}
