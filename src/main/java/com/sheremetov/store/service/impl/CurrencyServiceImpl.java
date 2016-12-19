package com.sheremetov.store.service.impl;

import com.sheremetov.store.model.Currency;
import com.sheremetov.store.service.CurrencyService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by denis on 12/5/2016.
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

    public String convert(Double amount, Currency cur) {
        return String.format("%.2f %s", cur.getRate() * amount, cur.toString());
    }

    @Override
    public Currency[] currencies() {
        return Currency.values();
    }

}