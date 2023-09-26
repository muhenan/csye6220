package com.example.hw4part8.controller;

import com.example.hw4part8.utils.MyUtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RandomController {

    @Autowired
    public MyUtilityClass myUtilityClass;
    @GetMapping("random")
    public String getRandomPage(Model model) {
        model.addAttribute("message", myUtilityClass.getARandomString());
        System.out.println("Utility class instance ID: " + System.identityHashCode(myUtilityClass));
        return "random";
    }
}