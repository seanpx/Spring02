package com.seanpx.Spring02;


import com.seanpx.Main;
import com.seanpx.controller.UserController;
import com.seanpx.domain.User;
import com.seanpx.utils.JsonData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Main.class})
public class XdUserTest {

    @Autowired
    private UserController userController;

    @Test
    public void loginTest(){
        User user = new User();
        //user.setId(7);
        user.setUsername("XdUserTest");
        user.setPwd("112233");

        JsonData jsonData = userController.login(user);

        System.out.println(jsonData.toString());

        Assertions.assertEquals(0,jsonData.getCode());

    }

    @Test
    public void loginTest2(){
        User user2 = new User();
        user2.setId(1);
        user2.setUsername("user1");
        user2.setPwd("abc123#1");

        JsonData jsonData = userController.login(user2);

        System.out.println(jsonData.toString());

        Assertions.assertEquals(0,jsonData.getCode());

    }

}
