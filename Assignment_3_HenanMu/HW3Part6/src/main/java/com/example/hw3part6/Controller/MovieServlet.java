package com.example.hw3part6.Controller;

import com.example.hw3part6.Model.Movie;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.sql.*;

import java.io.*;
import java.util.*;

@WebServlet(name = "MovieServlet", value = "/MovieServlet")
public class MovieServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String JDBC_URL = "jdbc:mysql://newton.neu.edu:3306/usersdb";
    private static final String JDBC_USER = "student";
    private static final String JDBC_PASSWORD = "p@ssw0rd";

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        request.setAttribute("movies", movies);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSP/moviestore.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
