package com.example.hw4part4.controller;

import com.example.hw4part4.model.Movie;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoviesController extends AbstractController {


    private static final String JDBC_URL = "jdbc:mysql://csye6220henanmudbinstance.clq6tj9obseo.us-east-2.rds.amazonaws.com:3306/csye6220henanmudb";
    private static final String JDBC_USER = "admin";
    private static final String JDBC_PASSWORD = "12345678";

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {


        String action = httpServletRequest.getParameter("action");
        if (action != null) {
            if (action.equals("adda")) return new ModelAndView("addmovie");
            if (action.equals("addmul")) return new ModelAndView("addmultiplemovies");
            if (action.equals("searchmovie")) return new ModelAndView("searchmovie");
        }

        ModelAndView modelAndView = new ModelAndView("moviestore");


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }


        List<Movie> movies = new ArrayList<>();


        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM movietable");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setName(rs.getString("name"));
                movie.setDirector(rs.getString("director"));
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        modelAndView.addObject("movies", movies);

        return modelAndView;
    }
}
