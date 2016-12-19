package com.sheremetov.store.service.impl;

import com.sheremetov.store.model.Cart;
import com.sheremetov.store.model.Currency;
import com.sheremetov.store.service.CurrencyService;
import com.sheremetov.store.service.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * Created by denis on 12/11/2016.
 */
public class UserSessionImpl implements UserSession {

    private static final Currency DEFAULT_CURRENCY = Currency.PLN;

    private Currency currency = DEFAULT_CURRENCY;

    private Cart cart = new Cart();

    public Cart getCart() {
        return cart;
    }

    public void setCurrency(Currency value) {
        currency = value;
    }

    public void setCurrency(String value) {
        currency = Currency.fromString(value, DEFAULT_CURRENCY);
    }

    public Currency getCurrency() {
        return currency;
    }
}
