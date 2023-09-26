package com.example.hw3part6.Controller;

import com.example.hw3part6.Model.Movie;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchMovieServlet", value = "/SearchMovieServlet")
public class SearchMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");

        List<Movie> movies = new ArrayList<Movie>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://newton.neu.edu:3306/usersdb";
            String username = "student";
            String password = "p@ssw0rd";

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

        request.setAttribute("movies", movies);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSP/searchresult.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
