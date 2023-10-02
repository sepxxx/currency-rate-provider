package com.bnk.currencyrateclient.controller;

import com.bnk.currencyrateclient.model.CurrencyRate;
import com.bnk.currencyrateclient.model.RateType;
import com.bnk.currencyrateclient.services.CurrencyRateEndpointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@Slf4j
@RequestMapping(path="${app.rest.api.prefix}/v1")
@RequiredArgsConstructor
public class CurrencyRateEndpointController {
    private final CurrencyRateEndpointService currencyRateEndpointService;

    @GetMapping("/currencyRate/{rateType}/{currency}/{date}")
    public CurrencyRate getCurrencyRate(@PathVariable("rateType") RateType rateType,
                                        @PathVariable("currency") String currency,
                                         @DateTimeFormat(pattern="dd-MM-yyyy") @PathVariable("date") LocalDate date) {
        log.info("getCurrencyRate, currency:{}, date:{}", currency, date);
        CurrencyRate rate = currencyRateEndpointService.getCurrencyRate(rateType, currency, date);
        log.info("rate:{}", rate);
        return rate;
    }

}
