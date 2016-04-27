package com.inno.modelview.dao;

import com.inno.modelview.model.Contributor;
import com.inno.modelview.model.Popularity;

public interface IUserDao {

    void savePopularity(Popularity popularity);

    void saveContributor(Contributor contributor);

}
