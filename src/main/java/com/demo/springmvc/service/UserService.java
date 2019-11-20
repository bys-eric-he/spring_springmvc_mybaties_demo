package com.demo.springmvc.service;

import com.demo.springmvc.model.UserInfo;

import java.util.List;

public interface UserService {

    UserInfo getUserById(int id);

    List<UserInfo> getUsers();

    int insert(UserInfo userInfo);
}
