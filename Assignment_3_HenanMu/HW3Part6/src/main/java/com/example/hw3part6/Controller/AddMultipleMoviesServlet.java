package com.example.hw3part6.Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "AddMultipleMoviesServlet", value = "/AddMultipleMoviesServlet")
public class AddMultipleMoviesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name1 = request.getParameter("name1");
        String director1 = request.getParameter("director1");
        String name2 = request.getParameter("name2");
        String director2 = request.getParameter("director2");
        String name3 = request.getParameter("name3");
        String director3 = request.getParameter("director3");

        // JDBC database connection details
        String url = "jdbc:mysql://newton.neu.edu:3306/usersdb";
        String user = "student";
        String password = "p@ssw0rd";

        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);

            // Construct SQL statements for inserting movies
            String sql1 = "INSERT INTO movietable (name, director) VALUES (?, ?)";
            String sql2 = "INSERT INTO movietable (name, director) VALUES (?, ?)";
            String sql3 = "INSERT INTO movietable (name, director) VALUES (?, ?)";

            // Prepare the SQL statements
            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            PreparedStatement stmt3 = conn.prepareStatement(sql3);

            // Set the parameters for the first movie
            stmt1.setString(1, name1);
            stmt1.setString(2, director1);

            // Set the parameters for the second movie
            stmt2.setString(1, name2);
            stmt2.setString(2, director2);

            // Set the parameters for the third movie
            stmt3.setString(1, name3);
            stmt3.setString(2, director3);

            // Execute the SQL statements to insert the movies
            stmt1.executeUpdate();
            stmt2.executeUpdate();
            stmt3.executeUpdate();

            // Close the prepared statements and the connection
            stmt1.close();
            stmt2.close();
            stmt3.close();
            conn.close();

            // Redirect the user to the movie list page

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSP/addsucceed.jsp");
            requestDispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
