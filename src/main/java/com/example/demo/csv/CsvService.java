package com.example.demo.csv;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.example.demo.s3.S3Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class CsvService {

    @Autowired
    private S3Service s3Service;

    @Autowired
    private CsvBuilderFactory csvBuilderFactory;

    public String process(String ruleName, LambdaLogger logger) throws IOException {
        CsvBuilder csvBuilder = csvBuilderFactory.getCsvBuilder(ruleName);
        Path path;
        try {
            path = csvBuilder.buildCsvFile();
        } catch (IOException e) {
            log.info(e.getMessage());
            logger.log("lambda: " + e.getMessage());
            return "Failed";
        }
        return Files.readString(path);
    }

}
