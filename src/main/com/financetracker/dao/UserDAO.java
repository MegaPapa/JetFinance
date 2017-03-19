package com.financetracker.dao;

import com.financetracker.bean.User;

import java.util.Collection;

/**
 * Created by User on 13.03.2017.
 */
public interface UserDAO {

    /* CRUD Operations */

    // CREATE
    void addUser(User user);

    // READ
    User getUserById(int id);

    // READ
    Collection<User> getAllUsers();
}
