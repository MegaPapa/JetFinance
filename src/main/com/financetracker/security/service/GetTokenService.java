package com.financetracker.security.service;

import com.financetracker.security.service.exception.AuthenticationException;

/**
 * Created by User on 02.05.2017.
 */

public interface GetTokenService {
    String getToken(String email, String password) throws AuthenticationException;
}
