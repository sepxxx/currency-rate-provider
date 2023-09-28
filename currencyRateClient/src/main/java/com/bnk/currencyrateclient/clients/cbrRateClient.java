package com.bnk.currencyrateclient.clients;

import com.bnk.currencyrateclient.model.CurrencyRate;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service("cbr")
@RequiredArgsConstructor
public class cbrRateClient implements RateClient{

    private final httpClientJdk httpClient;
    private final ObjectMapper objectMapper;
    private final

    @Override
    public CurrencyRate getCurrencyRate() {

    }
}
