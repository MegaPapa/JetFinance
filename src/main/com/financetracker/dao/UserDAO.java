package com.financetracker.dao;

import java.util.Collection;

/**
 * Created by User on 13.03.2017.
 */
public interface UserDAO {

    /* CRUD Operations */

    // CREATE
    void addUser(UserBean user);

    // READ
    UserBean getUserById(int id);

    // READ
    Collection<UserBean> getAllUsers();
}
