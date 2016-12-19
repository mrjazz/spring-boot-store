package com.sheremetov.store.repository;

import com.sheremetov.store.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.ArrayList;


/**
 * Created by denis on 10/17/2015.
 */
public interface CategoriesRepository extends Repository<Category, String> {

    @Query(value = "SELECT M.category FROM Movie M GROUP BY M.category")
    public ArrayList<Category> findAll();

}
