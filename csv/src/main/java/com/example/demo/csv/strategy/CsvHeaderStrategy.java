package main.java.com.example.demo.csv.strategy;

@FunctionalInterface
public interface CsvHeaderStrategy {
    Iterable<?> header();
}
