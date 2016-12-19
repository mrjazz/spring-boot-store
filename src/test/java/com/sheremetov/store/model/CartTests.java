package com.sheremetov.store.model;

import com.sheremetov.store.repository.MoviesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class CartTests {

    @Test
    public void addAndRemoveInCart() {
        Cart cart = new Cart();
        assertThat(cart.getItems()).isNotNull();
        Movie movie = new Movie();
        movie.setTitle("Test Movie");
        movie.setPrice(9.99);

        cart.addMovie(new CartItem(movie, 2));

        CartItem actualItem = cart.getItems().iterator().next();

        assertThat(actualItem.getMovie()).isEqualTo(movie);
        assertThat(actualItem.getQuantity()).isEqualTo(2);
        assertThat(cart.total()).isEqualTo(19.98);
    }

}
