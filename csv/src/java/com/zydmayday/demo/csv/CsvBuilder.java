package com.zydmayday.demo.csv;

import java.io.IOException;
import java.nio.file.Path;

public interface CsvBuilder {
    /**
     * Create a temp csv file with given header and values
     * @return created csv file path
     */
    Path buildCsvFile() throws IOException;
}
