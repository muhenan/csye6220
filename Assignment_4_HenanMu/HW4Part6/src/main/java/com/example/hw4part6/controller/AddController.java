package com.example.hw4part6.controller;

import com.example.hw4part6.model.MyCart;
import com.example.hw4part6.model.ShoppingCart;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddController {
    @PostMapping("add")
    public String additems(HttpServletRequest request, Model model) {
        String[] items = request.getParameterValues("item");
        if (MyCart.myCart == null) {
            MyCart.myCart = new ShoppingCart();
        }
        ShoppingCart cart = MyCart.myCart;
        if (items != null) {
            for (String item : items) {
                cart.addItem(item);
            }
        }
        return "addsucceed";
    }
}
