package com.example.demo.config;

import com.example.demo.csv.CsvBuilderFactory;
import com.example.demo.csv.CsvService;
import com.example.demo.db.repository.MovieRepository;
import com.example.demo.db.repository.UserRepository;
import com.example.demo.s3.S3Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

@Configuration
public class Config {

    @Bean
    S3Client s3Client() {
        return S3Client.builder()
                       .httpClientBuilder(ApacheHttpClient.builder())
                       .region(Region.AP_NORTHEAST_1)
                       .endpointOverride(URI.create("https://s3-ap-northeast-1.amazonaws.com"))
                       .build();
    }

    @Bean
    S3Service s3Service() {
        return new S3Service();
    }

    @Bean
    public CsvService csvService() {
        return new CsvService();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }

    @Bean
    public MovieRepository movieRepository() {
        return new MovieRepository();
    }

    @Bean
    public CsvBuilderFactory csvBuilderFactory() {
        return new CsvBuilderFactory();
    }
}
