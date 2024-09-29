package com.seanpx.mapper;

import com.seanpx.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserMapper {
    private static Map<String, User> userMap = new LinkedHashMap<>();

    static {
        System.out.println("UserMapper - Static - Starting");

        userMap.put("user1",new User(1,"user1","abc123#1"));
        userMap.put("user2",new User(2,"user2","abc123#2"));
        userMap.put("user3",new User(3,"user3","abc123#3"));

        System.out.println("UserMapper - Static - Ending");
    }

    public User login(String username, String pwd){
        User user = userMap.get(username);

        if (user == null){
            return null;
        }

        if (user.getPwd().equals(pwd)){
            return user;
        }

        return null;
    }

    public List<User> listUser(){
        List<User> list = new ArrayList<>();
        userMap.values();
        list.addAll(userMap.values());
        return list;
    }

}
