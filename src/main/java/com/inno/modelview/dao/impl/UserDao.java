package com.inno.modelview.dao.impl;

import com.inno.modelview.dao.IUserDao;
import com.inno.modelview.model.Contributor;
import com.inno.modelview.model.Popularity;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao implements IUserDao {
    @Override
    public void savePopularity(Popularity popularity) {
        saveOrUpdate(popularity);
    }

    @Override
    public void saveContributor(Contributor contributor) {
        saveOrUpdate(contributor);
    }
}
