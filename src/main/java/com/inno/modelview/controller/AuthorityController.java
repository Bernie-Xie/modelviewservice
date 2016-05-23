package com.inno.modelview.controller;

import com.inno.modelview.model.Login.Token;
import com.inno.modelview.model.Login.UserLogin;
import com.inno.modelview.service.IAuthorityService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Will on 2016-5-21.
 */
@Controller
public class AuthorityController {

    final static String CLAIMS = "claims";

    @Autowired
    IAuthorityService authorityService;

    /**
     * The response is setup token for subsequent api callings
     */
    @RequestMapping(value="/login", method= RequestMethod.POST)
    public ResponseEntity login(@RequestBody final UserLogin login){
        Token token;
        try {
            token = authorityService.login(login);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(token, HttpStatus.CREATED);
    }

    /**
     * To remove the token info in the backend server.
     */
    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public ResponseEntity logout(final HttpServletRequest request){
        final Claims claims = (Claims) request.getAttribute(CLAIMS);
        try {
            authorityService.logout(claims);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
