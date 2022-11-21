package com.zydmayday.demo.csv;

import com.zydmayday.demo.csv.constant.UnknownRuleException;
import com.zydmayday.demo.csv.strategy.MovieRepositoryStrategy;
import com.zydmayday.demo.csv.strategy.UserRepositoryStrategy;
import com.zydmayday.demo.db.entity.MovieEntity;
import com.zydmayday.demo.db.entity.UserEntity;
import com.zydmayday.demo.db.repository.MovieRepository;
import com.zydmayday.demo.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static com.zydmayday.demo.csv.constant.Rule.RULE_USER;
import static com.zydmayday.demo.csv.constant.Rule.RULE_MOVIE;

public class CsvBuilderFactory {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    public CsvBuilder getCsvBuilder(String ruleName) {
        switch (ruleName) {
            case RULE_USER: {
                return CsvBuilderImpl
                        .<UserEntity>builder()
                        .csvFileNameStrategy(() -> "/tmp/user.csv")
                        .csvHeaderStrategy(() -> Arrays.asList("name", "age"))
                        .repositoryStrategy(new UserRepositoryStrategy(userRepository))
                        .build();
            }
            case RULE_MOVIE: {
                return CsvBuilderImpl
                        .<MovieEntity>builder()
                        .csvFileNameStrategy(() -> "/tmp/movie.csv")
                        .csvHeaderStrategy(() -> List.of("title"))
                        .repositoryStrategy(new MovieRepositoryStrategy(movieRepository))
                        .build();
            }
            default: {
                throw new UnknownRuleException("Given rule is invalid, rule: " + ruleName);
            }
        }

    }
}
