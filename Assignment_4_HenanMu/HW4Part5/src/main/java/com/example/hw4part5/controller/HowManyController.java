package com.example.hw4part5.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HowManyController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String numberOfBooks = request.getParameter("numberOfBooks");
        ModelAndView modelAndView = new ModelAndView("addbooks");
        modelAndView.addObject("numberOfBooks", numberOfBooks);
        return modelAndView;
    }
}
