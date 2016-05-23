package com.inno.modelview.service.impl;

import com.inno.modelview.exception.UserNotFoundException;
import com.inno.modelview.model.Login.Token;
import com.inno.modelview.model.Login.UserLogin;
import com.inno.modelview.model.Login.UserRole;
import com.inno.modelview.service.IAuthorityService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Will Hu on 2016-5-21.
 */
@Service
public class AuthorityService implements IAuthorityService {

    final static String SECRET_KEY = "SECRETKEY"; // TODO need to be change to complex string and config in resource file
    private final Map<String, List<UserRole>> userDb = new HashMap<>();

    // Test data
    public AuthorityService() {
        userDb.put("u377539", Arrays.asList(UserRole.USER, UserRole.ADMIN));
        userDb.put("su", Arrays.asList(UserRole.USER, UserRole.ADMIN));
        userDb.put("u10000", Arrays.asList(UserRole.USER));
    }

    @Override
    public Token login(UserLogin login) {
        if (login.getName() == null || !userDb.containsKey(login.getName())) {
            throw new UserNotFoundException();
        }
        Date startDatetime = new Date();
        String token = Jwts.builder().setSubject(login.getName())
                .claim("roles", userDb.get(login.getName()))
                .setIssuedAt(startDatetime)
                .setExpiration(tokenExpireDate(startDatetime))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        System.out.println(login.getName() + "getToken");
        return new Token(token);
    }

    @Override
    public void logout(Claims claims) {
        String username = (String) claims.get("sub");
        List<UserRole> roles = (List<UserRole>)claims.get("roles");
        System.out.println(username + roles.toString());
    }

    private Date tokenExpireDate(Date startDate) {
        GregorianCalendar gc=new GregorianCalendar();
        gc.setTime(startDate);
        gc.add(gc.DATE, 1); //Token expired after 1 day.
        return gc.getTime();
    }
}
