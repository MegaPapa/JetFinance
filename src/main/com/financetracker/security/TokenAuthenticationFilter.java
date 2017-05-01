package com.financetracker.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 02.05.2017.
 */

public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final static String TOKEN = "token";
    private final static String FILTER_PATH = "/*";

    public TokenAuthenticationFilter() {
        super(FILTER_PATH);
    }


    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        String token;

        token = request.getHeader(TOKEN);

        if ((token == null) || token.isEmpty()) {
            token = request.getParameter(TOKEN);
        }

        if (token == null || token.isEmpty()) {
            TokenAuthentication tokenAuthentication = new TokenAuthentication(null, null);
            tokenAuthentication.setAuthenticated(true);
            return tokenAuthentication;
        }

        TokenAuthentication tokenAuthentication = new TokenAuthentication(token);
        return getAuthenticationManager().authenticate(tokenAuthentication);
    }

    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
        return true;
    }

    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        chain.doFilter(request, response);
    }
}

