package com.example.hw3part7books.Controller;

import com.example.hw3part7books.Model.Book;
import com.example.hw3part7books.Model.BookDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "AddBooksServlet", value = "/AddBooksServlet")
public class AddBooksServlet extends HttpServlet {

    private BookDAO bookDAO;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int numberOfBooks = Integer.parseInt(request.getParameter("numberOfBooks"));

        try {
            bookDAO = new BookDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int i = 1; i <= numberOfBooks; i++) {
            String isbn = request.getParameter("isbn" + i);
            String title = request.getParameter("title" + i);
            String authors = request.getParameter("authors" + i);
            float price = Float.parseFloat(request.getParameter("price" + i));

            Book book = new Book(isbn, title, authors, price);
            try {
                bookDAO.addBook(book);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        String numberOfBooksString = request.getParameter("numberOfBooks");
        request.setAttribute("numberOfBooks", numberOfBooksString);

        request.getRequestDispatcher("jsp/addSucceed.jsp").forward(request, response);
    }
}
