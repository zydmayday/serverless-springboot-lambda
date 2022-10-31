package main.java.com.example.demo.csv;

import main.java.com.example.demo.csv.constant.UnknownRuleException;
import main.java.com.example.demo.csv.strategy.MovieRepositoryStrategy;
import main.java.com.example.demo.csv.strategy.UserRepositoryStrategy;
import main.java.com.example.demo.db.entity.MovieEntity;
import main.java.com.example.demo.db.entity.UserEntity;
import main.java.com.example.demo.db.repository.MovieRepository;
import main.java.com.example.demo.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static main.java.com.example.demo.csv.constant.Rule.RULE_USER;
import static main.java.com.example.demo.csv.constant.Rule.RULE_MOVIE;

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
