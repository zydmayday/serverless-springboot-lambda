package com.example.demo.csv;

import com.example.demo.csv.strategy.CsvFileNameStrategy;
import com.example.demo.csv.strategy.CsvHeaderStrategy;
import com.example.demo.csv.strategy.RepositoryStrategy;
import lombok.Builder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Builder
public class CsvBuilderImpl<T> implements CsvBuilder {

    private CsvHeaderStrategy csvHeaderStrategy;
    private CsvFileNameStrategy csvFileNameStrategy;
    private RepositoryStrategy<T> repositoryStrategy;

    @Override
    public Path buildCsvFile() throws IOException {
        return buildCsvFile(csvFileNameStrategy.fileName(),
                            csvHeaderStrategy.header(),
                            repositoryStrategy.getEntities());
    }

    public Path buildCsvFile(String fileName, Iterable<?> header, Iterable<T> values) throws IOException {
        Path path = Paths.get(fileName);
        try (CSVPrinter printer = new CSVPrinter(Files.newBufferedWriter(path), CSVFormat.DEFAULT)) {
            printer.printRecord(header);
            for (T entity : values) {
                printer.printRecord(repositoryStrategy.mapToValue(entity));
            }
        }
        return path;
    }
}
