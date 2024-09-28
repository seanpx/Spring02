package com.seanpx.controller;

import com.seanpx.domain.User;
import com.seanpx.service.UserService;
import com.seanpx.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pub/user")
public class UserController {

//    @PostMapping("login")
//    public JsonData login(String pwd, String username){
//
//        System.out.println("User: " + username + " Pswd: " + pwd);
//
//        return JsonData.buildSuccess("");
//    }

    @Autowired
    public UserService userService;

    @PostMapping("login")
    public JsonData login(@RequestBody User user){

        System.out.println("user: " + user.toString());

        String token = userService.login(user.getUsername(),user.getPwd());

//        return JsonData.buildSuccess("");
        return token !=null ? JsonData.buildSuccess(token): JsonData.buildError("Incorrect Account / Password");
    }

    /*
     * Return
     */
    @GetMapping("list_user")
    public JsonData listUser(){
        return JsonData.buildSuccess(userService.listUser());
    }

}
