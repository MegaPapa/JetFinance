package com.financetracker.dao;

import com.financetracker.bean.Role;
import com.financetracker.bean.StockTickers;
import com.financetracker.bean.User;
import com.financetracker.dao.exception.DAOException;

import java.util.List;
import java.util.Set;

public interface UserDAO {

    /* CRUD Operations */

    // CREATE
    void addUser(User user) throws DAOException;
    void addStockTicker(int userId, String tickerName) throws DAOException;

    // READ
    User getUserById(int id) throws DAOException;
    User getUserByEmail(String email) throws DAOException;
    Set<StockTickers> getUserTickers(int id) throws DAOException;
    Role getRoleByName(String roleName) throws DAOException;

    // UPDATE
    void UpdateUser(User newUserInfo, int id) throws DAOException;
    void setUserStatus(int id, boolean status) throws DAOException;

    // READ
    List<User> getAllUsers() throws DAOException;
}
