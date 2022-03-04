package com.example.demo.csv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.example.demo.csv.constant.Rule.RULE_MOVIE;
import static com.example.demo.csv.constant.Rule.RULE_USER;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CsvBuilderFactoryTest {

    @Autowired
    private CsvBuilderFactory csvBuilderFactory;

    @Test
    void test_rule1() throws IOException {
        CsvBuilder builder = csvBuilderFactory.getCsvBuilder(RULE_USER);
        Path path = builder.buildCsvFile();
        String content = Files.readString(path);
        assertTrue(content.contains("name"));
        assertTrue(content.contains("user"));
    }

    @Test
    void test_rule2() throws IOException {
        CsvBuilder builder = csvBuilderFactory.getCsvBuilder(RULE_MOVIE);
        Path path = builder.buildCsvFile();
        String content = Files.readString(path);
        assertTrue(content.contains("title"));
        assertTrue(content.contains("movie1"));
    }
}
