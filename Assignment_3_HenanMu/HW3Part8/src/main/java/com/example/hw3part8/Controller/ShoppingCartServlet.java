package com.example.hw3part8.Controller;

import com.example.hw3part8.Model.ShoppingCart;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Base64;

@WebServlet(name = "ShoppingCartServlet", value = "/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
    private ShoppingCart cart;

    @Override
    public void init() throws ServletException {
        super.init();
        cart = new ShoppingCart();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!isUserAuthorized(request, response)) {
            response.setHeader("WWW-Authenticate", "Basic realm=\"Shopping Cart\"");
            response.sendError(401, "Unauthorized");
        } else {
            // Authorized! Let's go to the MVC shopping cart
            String action = request.getParameter("action");
            if (action != null && action.equals("shopping-cart")) {
                handleShoppingCartAction(request, response);
            } else {
                displayShoppingCart(request, response);
            }
        }
    }

    private void handleShoppingCartAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] items = request.getParameterValues("item");
        if (items != null) {
            for (String item : items) {
                cart.addItem(item);
            }
        }
        String removeIndex = request.getParameter("removeIndex");
        if (removeIndex != null && !removeIndex.isEmpty()) {
            int index = Integer.parseInt(removeIndex);
            cart.removeItem(index);
        }
        displayShoppingCart(request, response);
    }

    private void displayShoppingCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("cart", cart.getItems());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP/shoppingcart.jsp");
        dispatcher.forward(request, response);
    }


    private boolean isUserAuthorized(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
