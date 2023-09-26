package com.example.hw4part7.controller;

import com.example.hw4part7.utils.MyUtilityClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RandomController {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    @GetMapping("random")
    public String getRandomPage(Model model) {
        MyUtilityClass myUtilityClass = context.getBean("myUtilityClass", MyUtilityClass.class);
        model.addAttribute("message", myUtilityClass.getARandomString());
        System.out.println("Utility class instance ID: " + System.identityHashCode(myUtilityClass));
        return "random";
    }
}
