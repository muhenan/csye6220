package com.example.hw3part7books.Model;

import java.sql.*;
import java.util.*;

public class BookDAO {
    private Connection connection;

    public BookDAO() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://newton.neu.edu:3306/usersdb", "student", "p@ssw0rd");
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

//    public void updateBook(Book book) throws SQLException {
//        String sql = "UPDATE books SET isbn = ?, title = ?, authors = ?, price = ? WHERE id = ?";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, book.getIsbn());
//        statement.setString(2, book.getTitle());
//        statement.setString(3, book.getAuthors());
//        statement.setFloat(4, book.getPrice());
//        statement.setInt(5, book.getId());
//        statement.executeUpdate();
//    }

//    public void deleteBook(int id) throws SQLException {
//        String sql = "DELETE FROM books WHERE id = ?";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setInt(1, id);
//        statement.executeUpdate();
//    }

//    public Book getBookById(int id) throws SQLException {
//        String sql = "SELECT * FROM books WHERE id = ?";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setInt(1, id);
//        ResultSet result = statement.executeQuery();
//        if (result.next()) {
//            String isbn = result.getString("isbn");
//            String title = result.getString("title");
//            String authors = result.getString("authors");
//            float price = result.getFloat("price");
//            return new Book(id, isbn, title, authors, price);
//        }
//        return null;
//    }

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
