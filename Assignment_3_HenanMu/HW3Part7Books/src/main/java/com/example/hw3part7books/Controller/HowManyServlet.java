package com.example.hw3part7books.Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "HowManyServlet", value = "/HowManyServlet")
public class HowManyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numberOfBooks = request.getParameter("numberOfBooks");
        request.setAttribute("numberOfBooks", numberOfBooks);
        request.getRequestDispatcher("jsp/addBooks.jsp").forward(request, response);
    }
}
