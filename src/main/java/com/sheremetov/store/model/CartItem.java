package com.sheremetov.store.model;


/**
 * Created by denis on 10/14/2015.
 */
public class CartItem {

    private Movie movie;
    private int quantity;

    public CartItem(Movie movie, int quantity) {
        this.movie = movie;
        this.quantity = quantity;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
