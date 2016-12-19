package com.sheremetov.store.web;

import com.sheremetov.store.service.CurrencyService;
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
public class CurrencyController {

    public static final String URL_CURRENCY = "/currency";

    @Autowired
    private UserSession userSession;

    @RequestMapping(value = URL_CURRENCY, method = RequestMethod.POST)
    public String addToCart(HttpServletRequest req) {
        userSession.setCurrency(req.getParameter("currency"));
        return "redirect:" + req.getHeader("referer");
    }

}