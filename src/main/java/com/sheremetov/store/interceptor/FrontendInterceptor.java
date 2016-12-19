package com.sheremetov.store.interceptor;

import com.sheremetov.store.repository.CategoriesRepository;
import com.sheremetov.store.service.CurrencyService;
import com.sheremetov.store.service.impl.UserSessionImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by denis on 12/7/2016.
 */
@Component
public class FrontendInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(FrontendInterceptor.class);

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private CategoriesRepository categoriesRepository;

    private UserSessionImpl userSession;

    public void setUserSession(UserSessionImpl userSession) {
        this.userSession = userSession;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && modelAndView.getViewName().startsWith("redirect:")) {
            return; // no sense prepare state for redirect
        }

        modelAndView.addObject("currency", userSession.getCurrency());
        modelAndView.addObject("curService", currencyService);
        modelAndView.addObject("categories", categoriesRepository.findAll());
        modelAndView.addObject("cart", userSession.getCart());
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}