package com.seanpx.service.impl;

import com.seanpx.domain.User;
import com.seanpx.mapper.UserMapper;
import com.seanpx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    private static Map<String, User> sessionMap = new LinkedHashMap<>();
    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String pwd) {

        User user = userMapper.login(username,pwd);

        if (user == null){
            return null;
        }else{
            String token = UUID.randomUUID().toString();
            System.out.println(token);
            sessionMap.put(token,user);
            return token;
        }

    }

    @Override
    public List<User> listUser() {
        return userMapper.listUser();
    }
}
