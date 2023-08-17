package org.jingtao8a.service;

import org.jingtao8a.dao.UserDao;
import org.jingtao8a.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }
}
