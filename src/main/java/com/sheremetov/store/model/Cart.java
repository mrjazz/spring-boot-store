package com.sheremetov.store.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by denis on 10/14/2015.
 */
public class Cart {

    private HashMap<Number, CartItem> movies = new HashMap<>();

    public Double total() {
        Double result = 0.0;
        for (CartItem item : movies.values()) {
            result += item.getMovie().getPrice() * item.getQuantity();
        }
        return result;
    }

    public void addMovie(CartItem cartItem) {
        if (movies.containsKey(cartItem.getMovie().getId())) {
            CartItem curItem = movies.get(cartItem.getMovie().getId());
            curItem.setQuantity(curItem.getQuantity() + cartItem.getQuantity());
        } else {
            movies.put(cartItem.getMovie().getId(), cartItem);
        }
    }

    public void removeMovie(Number id) {
        movies.remove(id);
    }

    public Iterable<CartItem> getItems() {
        return movies.values();
    }

}
