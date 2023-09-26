package com.example.hw4part5.controller;

import com.example.hw4part5.model.Book;
import com.example.hw4part5.model.BookDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.sql.SQLException;
import java.util.List;

public class BookController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("howmany")) return new ModelAndView("howmanybooks");
        }
        ModelAndView modelAndView = new ModelAndView("bookcollection");
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
        modelAndView.addObject("books", books);
        return modelAndView;
    }
}
