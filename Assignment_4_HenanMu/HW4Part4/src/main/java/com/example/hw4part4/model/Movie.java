package com.example.hw4part4.model;

public class Movie {
    private int id;
    private String name;
    private String director;

    public Movie() {

    }

    public Movie(int id, String name, String director) {
        this.id = id;
        this.name = name;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
