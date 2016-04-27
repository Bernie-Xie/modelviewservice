package com.inno.modelview.service;

import com.inno.modelview.model.Contributor;
import com.inno.modelview.model.Popularity;

/**
 * The service is to handle users' activities
 */
public interface IUserService {

    void savePopularity(Popularity popularity);

    void saveContributor(Contributor contributor);
}
