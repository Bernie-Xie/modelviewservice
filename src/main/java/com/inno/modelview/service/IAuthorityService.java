package com.inno.modelview.service;

import com.inno.modelview.model.Login.Token;
import com.inno.modelview.model.Login.UserLogin;

/**
 * Created by Will on 2016-5-21.
 */
public interface IAuthorityService {

    Token login(UserLogin login);

}
