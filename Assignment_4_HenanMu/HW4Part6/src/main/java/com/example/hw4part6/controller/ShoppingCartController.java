package com.example.hw4part6.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.Base64;

@Controller
public class ShoppingCartController {

    @GetMapping("/shoppingcart")
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!isUserAuthorized(request)) {
            response.setHeader("WWW-Authenticate", "Basic realm=\"Shopping Cart\"");
            response.sendError(401, "Unauthorized");
            return null;
        } else {
            return "shoppingcart";
        }
    }

    private boolean isUserAuthorized(HttpServletRequest request) throws IOException, ServletException {
        if (request.getUserPrincipal() != null) {
            // user has already been authenticated
            return true;
        }
        String auth = request.getHeader("Authorization");
        if (auth == null) {
            return false;
        } else {
            String[] credentials = new String(Base64.getDecoder().decode(auth.substring(6).getBytes()), "UTF-8").split(":");
            String username = credentials[0];
            String password = credentials[1];
            request.login(username, password);
            if (request.isUserInRole("admin")) {
                return true;
            } else {
                return false;
            }
        }
    }
}
