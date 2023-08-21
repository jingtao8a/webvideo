package org.jingtao8a.controller;

import org.jingtao8a.model.Result;
import org.jingtao8a.model.User;
import org.jingtao8a.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class AuthController {
    @Autowired
    UserService userService;
    @RequestMapping(value="/register", method= RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestParam String userName, @RequestParam String email, @RequestParam String password, @RequestParam String img) {
        List<User> userList = userService.getUsersByUserName(userName);
        if (userList.size() != 0) {
            return new Result(409, "userName has been used");
        }
        userList = userService.getUsersByEmail(email);
        if (userList.size() != 0) {
            //email 已经被使用
            return new Result(409, "email has been used");
        }
        System.out.println(userName);
        System.out.println(email);
        userService.addUser(new User(null, userName, email, password, img));
        return new Result(200, "register success");
    }

    @RequestMapping(value="/login", method= RequestMethod.POST)
    public void login() {

    }

    @RequestMapping(value="/logout", method= RequestMethod.POST)
    public void logout() {

    }
}
