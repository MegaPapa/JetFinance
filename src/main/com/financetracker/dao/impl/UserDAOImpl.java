package com.financetracker.dao.impl;

import com.financetracker.bean.Role;
import com.financetracker.bean.User;
import com.financetracker.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by User on 13.03.2017.
 */
@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    private final static int USER_ROLE_INDEX = 1;

    //TODO add logging
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        Role role = session.get(Role.class, USER_ROLE_INDEX);
        user.setRoleByRoleId(role);
        System.out.println(user.getId());
        session.save(user);
    }

    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }

    public Collection<User> getAllUsers() {
        return null;
    }
}
