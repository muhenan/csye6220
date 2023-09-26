package com.example.hw4part4.controller;

import com.example.hw4part4.model.Movie;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchMovieController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        String keyword = httpServletRequest.getParameter("keyword");

        List<Movie> movies = new ArrayList<Movie>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://csye6220henanmudbinstance.clq6tj9obseo.us-east-2.rds.amazonaws.com:3306/csye6220henanmudb";
            String username = "admin";
            String password = "12345678";

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM movietable WHERE name LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String director = resultSet.getString("director");

                Movie movie = new Movie();
                movie.setId(id);
                movie.setName(name);
                movie.setDirector(director);

                movies.add(movie);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView("searchresult");
        modelAndView.addObject("movies", movies);
        return modelAndView;
    }
}
