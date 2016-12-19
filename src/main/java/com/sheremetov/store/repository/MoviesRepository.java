package com.sheremetov.store.repository;

import com.sheremetov.store.model.Movie;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by denis on 10/17/2015.
 */
public interface MoviesRepository extends CrudRepository<Movie, Integer> {

    Iterable<Movie> findByCategory(String category);
    Movie findById(Integer id);

}
