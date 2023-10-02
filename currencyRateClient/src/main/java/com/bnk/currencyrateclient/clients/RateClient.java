package com.bnk.currencyrateclient.clients;

import com.bnk.currencyrateclient.model.CurrencyRate;

import java.time.LocalDate;

public interface RateClient {
    public CurrencyRate getCurrencyRate(String currency, LocalDate date);
}
