package com.example.wsp_spring.controller;

import com.example.wsp_spring.model.SignService;
import com.example.wsp_spring.model.UserValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInController {

    private final SignService signService;

    @Autowired
    public SignInController(SignService signService) {
        this.signService = signService;
    }

    @GetMapping("/signIn")
    public String getSignIn() {
        return "view/sign_in_form";
    }

    @PostMapping("/signIn")
    public String PostSignIn(String userId, String userPassword, Model model) {
        System.out.println(userId + ", " + userPassword);
        UserValue userValue = signService.signIn(userId, userPassword);
        model.addAttribute("userValue", userValue);
        return "view/signed";
    }

}
