package com.wangyousong.blog.hutoolstudy.crypto;

import com.wangyousong.blog.hutoolstudy.crypto.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    void createUser() {
        userService.createUser();
    }

    @Test
    void sendSms() {
        userService.sendSms("0844b249aab7a909a3b508685b6e76fd");
    }
}