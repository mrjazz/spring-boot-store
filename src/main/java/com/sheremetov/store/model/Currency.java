package com.sheremetov.store.model;

/**
 * Created by denis on 12/5/2016.
 */
public enum Currency {

    PLN(1.0), EUR(0.22);

    private final Double rate;

    Currency(double rate) {
        this.rate = rate;
    }

    public static Currency fromString(String value, Currency byDefault) {
        if (value == null) {
            return byDefault;
        }

        switch (value.toUpperCase()) {
            case "PLN":
                return PLN;
            case "EUR":
                return EUR;
            default:
                return byDefault;
        }
    }

    public Double getRate() {
        return this.rate;
    }

}
