package com.inno.modelview.service.impl;

import com.inno.modelview.dao.IUserDao;
import com.inno.modelview.model.Contributor;
import com.inno.modelview.model.Popularity;
import com.inno.modelview.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public void savePopularity(Popularity popularity) {
        iUserDao.savePopularity(popularity);
    }

    @Override
    public void saveContributor(Contributor contributor) {
        iUserDao.saveContributor(contributor);
    }
}
