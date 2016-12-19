package com.sheremetov.store.service;

import com.sheremetov.store.model.Currency;
import org.springframework.context.annotation.Scope;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by denis on 12/5/2016.
 */
public interface CurrencyService {

    public String convert(Double amount, Currency cur);
    public Currency[] currencies();

}
