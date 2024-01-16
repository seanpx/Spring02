package com.seanpx.mapper;

import com.seanpx.domain.User;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserMapper {
    private static Map<Integer, User> userMap = new LinkedHashMap<>();

    static {
        userMap.put(1,new User(1,"user1","abc123"));
        userMap.put(2,new User(2,"user2","abc123"));
        userMap.put(3,new User(3,"user3","abc123"));
    }

}
