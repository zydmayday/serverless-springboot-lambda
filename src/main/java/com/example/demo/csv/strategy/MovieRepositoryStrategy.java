package com.example.demo.csv.strategy;

import com.example.demo.db.entity.MovieEntity;
import com.example.demo.db.repository.MovieRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class MovieRepositoryStrategy implements RepositoryStrategy<MovieEntity> {

    private MovieRepository movieRepository;

    @Override
    public Iterable<MovieEntity> getEntities() {
        return movieRepository.findAllMovies();
    }

    @Override
    public Iterable<?> mapToValue(MovieEntity entity) {
        return List.of(entity.getTitle());
    }
}
