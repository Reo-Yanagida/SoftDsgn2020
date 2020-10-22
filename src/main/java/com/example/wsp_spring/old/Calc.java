package com.example.wsp_spring.old;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Calc {

    @GetMapping("/calc")
    public String doGet() {
        return "old/calc_form";
    }

    @PostMapping("/calc")
    public String doPost(float x, float y, String mode, Model model) {
        model.addAttribute("keisanMode", new KeisanMode(x, y, mode));
        return "old/calc_ans";
    }

}
