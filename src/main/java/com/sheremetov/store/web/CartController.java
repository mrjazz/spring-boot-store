package com.sheremetov.store.web;

import com.sheremetov.store.model.CartItem;
import com.sheremetov.store.model.Movie;
import com.sheremetov.store.repository.MoviesRepository;
import com.sheremetov.store.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by denis on 11/12/2016.
 */
@Controller
public class CartController {

    private static final String URL_CHECKOUT = "/checkout";
    private static final String URL_CART_ADD = "/cart-add";
    private static final String URL_CART_REMOVE = "/cart-remove/{id}";

    private static final String FIELD_MOVIE_ID = "movie_id";
    private static final String FIELD_QUANTITY = "quantity";


    @Autowired
    private UserSession userSession;

    @Autowired
    private MoviesRepository moviesRepository;


    @RequestMapping(value = URL_CHECKOUT, method = RequestMethod.GET)
    public String checkout() {
        return "checkout/checkout";
    }

    @RequestMapping(value = URL_CART_REMOVE, method = RequestMethod.GET)
    public String removeFromCart(HttpServletRequest req, @PathVariable(required = true, value="id") Integer id) {
        userSession.getCart().removeMovie(id);
        return "redirect:" + req.getHeader("referer");
    }

    @RequestMapping(value = URL_CART_ADD, method = {RequestMethod.POST, RequestMethod.GET})
    public String addToCart(HttpServletRequest req) {
        processAddMovie(req);
        return "redirect:" + req.getHeader("referer");
    }

    private void processAddMovie(HttpServletRequest req) {
        Integer id = Integer.parseInt(req.getParameter(FIELD_MOVIE_ID));
        Integer quantity = Integer.parseInt(req.getParameter(FIELD_QUANTITY));

        if (id == null || quantity == null) return;

        Movie movie = moviesRepository.findById(id);

        if (movie == null) return;

        userSession.getCart().addMovie(new CartItem(movie, quantity));
    }

}