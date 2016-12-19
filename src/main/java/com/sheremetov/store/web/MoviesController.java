package com.sheremetov.store.web;

import com.sheremetov.store.model.Currency;
import com.sheremetov.store.model.Movie;
import com.sheremetov.store.repository.CategoriesRepository;
import com.sheremetov.store.repository.MoviesRepository;
import com.sheremetov.store.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by denis on 11/12/2016.
 */
@Controller
public class MoviesController {

    public static final String URL_HOME = "/";
    public static final String URL_MOVIE = "/movie/{id}";
    public static final String URL_CATEGORY = "/category/{title}";
    private static final String URL_CHECKOUT = "/checkout";

    @Autowired
    private MoviesRepository moviesRepository;


    @RequestMapping(URL_HOME)
    public String home(HttpServletRequest req, final Model model) {
        return category("ALL", req, model);
    }

    @RequestMapping(URL_CATEGORY)
    public String category(
            @PathVariable(value="title", required=true) String category,
            HttpServletRequest req,
            final Model model
    ) {
        if (category.equals("ALL")) {
            model.addAttribute("movies", moviesRepository.findAll());
            model.addAttribute("title", "All movies");
        } else {
            model.addAttribute("movies", moviesRepository.findByCategory(category));
            model.addAttribute("title", "Category " + category);
        }
        return "movies/catalog";
    }

    @RequestMapping(value = URL_MOVIE, method = RequestMethod.GET)
    public String product(
            @PathVariable(required = true, value="id") Integer id,
            HttpServletRequest req,
            final Model model
    ) {
        Movie movie = moviesRepository.findById(id);
        model.addAttribute("movie", movie);
        model.addAttribute("title", movie.getTitle());
        return "movies/product";
    }

    @RequestMapping(value = URL_MOVIE, method = RequestMethod.POST)
    public String addToCart(
            @PathVariable(required = true, value="id") Integer id,
            HttpServletRequest req,
            final Model model
    ) {
        model.addAttribute("movie", moviesRepository.findById(id));
        return "movies/product";
    }

    @RequestMapping(URL_CHECKOUT)
    public String checkout() {
        return "movies/checkout";
    }


}