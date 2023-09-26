package com.example.hw4part4.controller;

import com.example.hw4part4.model.Movie;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMovieController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("addsucceed");

        String name = httpServletRequest.getParameter("name");
        String director = httpServletRequest.getParameter("director");

        Movie movie = new Movie();
        movie.setName(name);
        movie.setDirector(director);

        try {
            // Get a connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://csye6220henanmudbinstance.clq6tj9obseo.us-east-2.rds.amazonaws.com:3306/csye6220henanmudb", "admin", "12345678");

            // Insert the new movie into the database
            String sql = "INSERT INTO movietable (name, director) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, movie.getName());
            statement.setString(2, movie.getDirector());
            statement.executeUpdate();

            // Close the database connection
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
