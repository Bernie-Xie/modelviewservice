package com.inno.modelview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by will on 16-5-21.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No user found")
public class UserNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1554251630974234515L;

}

