package com.example.wsp_spring.model;

import org.springframework.stereotype.Service;

@Service
public class SignService {

    public UserValue signIn(String userId, String userPassword) {
        if (userId.equals("b1960010") && userPassword.equals("qwerty")) {
            return new UserValue(userId, "千歳 光");
        }
        if (userId.equals("b2182360") && userPassword.equals("asdfgh")) {
            return new UserValue(userId, "三浦 一斗");
        }
        throw new RuntimeException("認証エラー");
    }

}
