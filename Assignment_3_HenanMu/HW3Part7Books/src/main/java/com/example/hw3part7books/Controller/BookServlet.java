package com.example.hw3part7books.Controller;

import com.example.hw3part7books.Model.Book;
import com.example.hw3part7books.Model.BookDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO bookDAO = null;
        try {
            bookDAO = new BookDAO();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<Book> books = null;
        try {
            books = bookDAO.getAllBooks();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("books", books);
        request.getRequestDispatcher("jsp/bookcollection.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
