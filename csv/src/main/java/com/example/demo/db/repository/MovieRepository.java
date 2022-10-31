package main.java.com.example.demo.db.repository;

import main.java.com.example.demo.db.entity.MovieEntity;

import java.util.Arrays;
import java.util.List;

public class MovieRepository {

    public List<MovieEntity> findAllMovies() {
        var movie1 = new MovieEntity("movie1");
        var movie2 = new MovieEntity("movie2");
        return Arrays.asList(movie1, movie2);
    }
}
