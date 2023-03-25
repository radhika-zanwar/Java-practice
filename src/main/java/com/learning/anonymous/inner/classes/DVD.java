package com.learning.anonymous.inner.classes;

public class DVD {
    private String movieName;
    private String genre;

    public DVD(String movieName, String genre) {
        this.movieName = movieName;
        this.genre = genre;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "movieName='" + movieName + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
