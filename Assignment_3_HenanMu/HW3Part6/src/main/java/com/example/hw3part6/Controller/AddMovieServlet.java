package com.example.hw3part6.Controller;

import com.example.hw3part6.Model.Movie;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "AddMovieServlet", value = "/AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String director = request.getParameter("director");

        Movie movie = new Movie();
        movie.setName(name);
        movie.setDirector(director);

        try {
            // Get a connection to the database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://newton.neu.edu:3306/usersdb", "student", "p@ssw0rd");

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

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSP/addsucceed.jsp");
        requestDispatcher.forward(request, response);
    }
}


