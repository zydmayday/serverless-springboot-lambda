package com.zydmayday.demo.csv.strategy;

@FunctionalInterface
public interface CsvHeaderStrategy {
    Iterable<?> header();
}
