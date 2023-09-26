package com.example.hw4part5.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://csye6220henanmudbinstance.clq6tj9obseo.us-east-2.rds.amazonaws.com:3306/csye6220henanmudb", "admin", "12345678");
    }

    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (isbn, title, authors, price) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, book.getIsbn());
        statement.setString(2, book.getTitle());
        statement.setString(3, book.getAuthors());
        statement.setFloat(4, book.getPrice());
        statement.executeUpdate();
    }


    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            String isbn = result.getString("isbn");
            String title = result.getString("title");
            String authors = result.getString("authors");
            float price = result.getFloat("price");
            books.add(new Book(isbn, title, authors, price));
        }
        return books;
    }

    public void close() throws SQLException {
        connection.close();
    }
}

