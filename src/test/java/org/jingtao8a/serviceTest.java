package org.jingtao8a;

import org.jingtao8a.config.SpringConfig;
import org.jingtao8a.model.User;
import org.jingtao8a.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class serviceTest {
    @Autowired
    UserService userService;

    @Test
    public void getUserById() {
        System.out.println(userService.getUserById(1));
        List<User> userList = userService.getUsersByUserName("root");
        System.out.println(userList);
        for (User user: userList) {
            System.out.println(user);
        }
    }
}
