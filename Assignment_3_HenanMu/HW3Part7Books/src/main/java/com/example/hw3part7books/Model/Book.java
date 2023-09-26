package com.example.hw3part7books.Model;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String authors;
    private float price;

    public Book(String isbn, String title, String authors, float price) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", price=" + price +
                '}';
    }
}
