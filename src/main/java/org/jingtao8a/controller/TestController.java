package org.jingtao8a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    @RequestMapping("/test1")
    @ResponseBody
    public String test1() {
        int a = 1 / 0;
        return "test1";
    }

    @RequestMapping("/test2")
    @ResponseBody
    public String test2(@RequestParam String fileName) {
        System.out.println(fileName);
        return "test2";
    }
}
