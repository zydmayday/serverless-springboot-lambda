package com.zydmayday.demo.csv.strategy;

public interface RepositoryStrategy<T> {

    /**
     * Fetch all data used by CSV file from DB
     * @return data list
     */
    Iterable<T> getEntities();

    /**
     * Map to one line data for csv file to print
     * @param entity fetched from DB
     * @return one line values
     */
    Iterable<?> mapToValue(T entity);
}
