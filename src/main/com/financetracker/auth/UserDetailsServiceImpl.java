package com.financetracker.auth;

import com.financetracker.dto.UserDTO;
import com.financetracker.service.UserService;
import com.financetracker.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 09.05.2017.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            UserDTO user = userService.getUserByEmail(email);
            Set<GrantedAuthority> roles = new HashSet();
            roles.add(new SimpleGrantedAuthority(
                    userService.getRoleByName(user.getRoleDTO().getRoleName()).getRoleName())
            );
            UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    roles
            );
            return userDetails;
        } catch (ServiceException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
