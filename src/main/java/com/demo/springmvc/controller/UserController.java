package com.demo.springmvc.controller;

import com.demo.springmvc.model.UserInfo;
import com.demo.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/showInfo/{userId}", method = {RequestMethod.GET})
    public String showUserInfo(ModelMap modelMap, @PathVariable int userId) {
        UserInfo userInfo = userService.getUserById(userId);
        modelMap.addAttribute("userInfo", userInfo);
        return "/showInfo";
    }

    @RequestMapping("/showInfos")
    @ResponseBody
    public Object showUserInfos() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public void insertUserInfo(@RequestBody UserInfo userInfo) {
        userService.insert(userInfo);
    }
}
