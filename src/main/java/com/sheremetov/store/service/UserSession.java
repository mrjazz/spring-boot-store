package com.sheremetov.store.service;

import com.sheremetov.store.model.Cart;
import com.sheremetov.store.model.Currency;

/**
 * Created by denis on 12/5/2016.
 */
public interface UserSession {

    public void setCurrency(Currency value);
    public void setCurrency(String value);
    public Currency getCurrency();
    public Cart getCart();

}
