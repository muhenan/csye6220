package com.example.hw4part6.controller;

import com.example.hw4part6.model.MyCart;
import com.example.hw4part6.model.ShoppingCart;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyCartController {
    @GetMapping("mycart")
    public String viewMyCart(HttpServletRequest request, Model model) {
        if (MyCart.myCart == null) {
            MyCart.myCart = new ShoppingCart();
        }
        model.addAttribute("cart", MyCart.myCart.getItems());
        return "mycart";
    }

    @GetMapping("remove")
    public String removeItem(HttpServletRequest request, Model model) {
        String removeIndex = request.getParameter("removeIndex");
        if (removeIndex != null && !removeIndex.isEmpty()) {
            int index = Integer.parseInt(removeIndex);
            MyCart.myCart.removeItem(index);
        }
        model.addAttribute("cart", MyCart.myCart.getItems());
        return "mycart";
    }
}
