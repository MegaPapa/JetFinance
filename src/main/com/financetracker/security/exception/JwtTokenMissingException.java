package com.financetracker.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by User on 02.05.2017.
 */
public class JwtTokenMissingException extends AuthenticationException {

    public JwtTokenMissingException(String msg, Throwable t) {
        super(msg, t);
    }

    public JwtTokenMissingException(String msg) {
        super(msg);
    }
}
