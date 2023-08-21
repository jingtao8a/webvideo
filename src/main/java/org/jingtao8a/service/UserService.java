package org.jingtao8a.service;

import org.jingtao8a.dao.UserDao;
import org.jingtao8a.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public List<User> getUsersByUserName(String userName) { return userDao.getUsersByUserName(userName); }

    public List<User> getUsersByEmail(String email) { return userDao.getUsersByEmail(email); }

    public void addUser(User user) { userDao.addUser(user);}
}
