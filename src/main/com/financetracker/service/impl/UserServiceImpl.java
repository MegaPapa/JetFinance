package com.financetracker.service.impl;

import com.financetracker.dao.UserDAO;
import com.financetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by User on 14.03.2017.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public void registration(UserBean user) {
        userDAO.addUser(user);
    }

    public UserBean getUser(int id) {
        return userDAO.getUserById(id);
    }

    public Collection<UserBean> getAllUsers() {
        return null;
    }
}
