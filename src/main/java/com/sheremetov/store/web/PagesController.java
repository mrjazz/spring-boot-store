package com.sheremetov.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by denis on 11/12/2016.
 */
@Controller
public class PagesController {

    private static final String URL_ABOUT = "/about";


    @RequestMapping(value = URL_ABOUT, method = RequestMethod.GET)
    public String about() {
        return "pages/about";
    }

}
