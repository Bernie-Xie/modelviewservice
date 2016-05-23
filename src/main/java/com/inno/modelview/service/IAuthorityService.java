package com.inno.modelview.service;

import com.inno.modelview.model.Login.Token;
import com.inno.modelview.model.Login.UserLogin;
import io.jsonwebtoken.Claims;

/**
 * Created by Will on 2016-5-21.
 */
public interface IAuthorityService {

    Token login(UserLogin login);

    void logout(Claims claims);

}
