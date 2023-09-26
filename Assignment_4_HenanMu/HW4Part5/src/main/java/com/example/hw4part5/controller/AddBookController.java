package com.example.hw4part5.controller;

import com.example.hw4part5.model.Book;
import com.example.hw4part5.model.BookDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.sql.SQLException;

public class AddBookController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int numberOfBooks = Integer.parseInt(request.getParameter("numberOfBooks"));

        BookDAO bookDAO;
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

        ModelAndView modelAndView = new ModelAndView("addsucceed");
        String numberOfBooksString = request.getParameter("numberOfBooks");
        modelAndView.addObject("numberOfBooks", numberOfBooksString);
        return modelAndView;
    }
}
