package org.jingtao8a.controller;

import org.jingtao8a.model.Result;
import org.jingtao8a.model.User;
import org.jingtao8a.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService userService;
    @RequestMapping(value="register", method= RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user) {
        List<User> userList = userService.getUsersByUserName(user.getUserName());
        if (userList.size() != 0) {
            return new Result(409, "userName has been used");
        }
        userList = userService.getUsersByEmail(user.getEmail());
        if (userList.size() != 0) {
            //email 已经被使用
            return new Result(409, "email has been used");
        }
        userService.addUser(user);
        return new Result(200, "register success");
    }

    @RequestMapping(value="login", method= RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody User user) {
        List<User> users = userService.getUsersByUserName(user.getUserName());
        if (users.size() == 0) {
            return new Result(404, "user not found");
        }
        if (!users.get(0).getPassword().equals(user.getPassword())) {
            return new Result(404, "password is wrong");
        }
        Result res = new Result(200, "login success");
        res.setExtentPack(users.get(0));
        return res;
    }

    @RequestMapping(value="logout", method= RequestMethod.POST)
    @ResponseBody
    public Result logout() {
        return new Result(200, "logout success");
    }
}
