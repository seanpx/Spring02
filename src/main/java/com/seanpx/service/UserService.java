package com.seanpx.service;

import com.seanpx.domain.User;

import java.util.List;

public interface UserService {
    String login(String username, String pwd);

    List<User> listUser();
}
