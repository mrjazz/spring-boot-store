package com.sheremetov.store.model;

import com.sheremetov.store.repository.CategoriesRepository;
import com.sheremetov.store.repository.MoviesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class CategoriesRepositoryTests {

    @Autowired
    protected CategoriesRepository categoriesRepository;
    
    @Test
    public void dataCheck() {
        assertThat(categoriesRepository).isNotNull();
        ArrayList<Category> categories = categoriesRepository.findAll();
        assertThat(categories.size()).isEqualTo(4);
    }

}
