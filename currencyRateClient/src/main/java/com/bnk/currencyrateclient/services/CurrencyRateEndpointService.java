package com.bnk.currencyrateclient.services;

import com.bnk.currencyrateclient.clients.RateClient;
import com.bnk.currencyrateclient.model.CurrencyRate;
import com.bnk.currencyrateclient.model.RateType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
@Slf4j
public class CurrencyRateEndpointService {

    private final Map<String, RateClient> clients;

    public CurrencyRateEndpointService(Map<String, RateClient> clients) {
        this.clients = clients;
    }
    public CurrencyRate getCurrencyRate(RateType rateType, String currency, LocalDate date) {
        log.info("getCurrencyRate. rateType:{}, currency:{}, date:{}", rateType, currency, date);
        RateClient rateClient = clients.get(rateType.getServiceName());
        return rateClient.getCurrencyRate(currency, date);
    }
}
