package com.demo.springmvc.service.impl;


import com.demo.springmvc.dao.UserInfoMapper;
import com.demo.springmvc.model.UserInfo;
import com.demo.springmvc.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    protected Logger log = Logger.getLogger(UserServiceImpl.class);

    public UserInfo getUserById(int id) {
        log.info("getUserById->".concat(String.valueOf(id)));
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public List<UserInfo> getUsers() {
        return userInfoMapper.selectAll();
    }

    public int insert(UserInfo userInfo) {

        int result = userInfoMapper.insert(userInfo);

        System.out.println(result);
        return result;
    }
}