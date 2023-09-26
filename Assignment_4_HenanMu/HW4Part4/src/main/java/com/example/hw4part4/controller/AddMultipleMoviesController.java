package com.example.hw4part4.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddMultipleMoviesController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        String name1 = httpServletRequest.getParameter("name1");
        String director1 = httpServletRequest.getParameter("director1");
        String name2 = httpServletRequest.getParameter("name2");
        String director2 = httpServletRequest.getParameter("director2");
        String name3 = httpServletRequest.getParameter("name3");
        String director3 = httpServletRequest.getParameter("director3");

        // JDBC database connection details
        String url = "jdbc:mysql://csye6220henanmudbinstance.clq6tj9obseo.us-east-2.rds.amazonaws.com:3306/csye6220henanmudb";
        String user = "admin";
        String password = "12345678";

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

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView("addsucceed");
    }
}
