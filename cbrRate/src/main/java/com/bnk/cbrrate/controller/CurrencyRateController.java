package com.bnk.cbrrate.controller;

import com.bnk.cbrrate.model.CurrencyRate;
import com.bnk.cbrrate.services.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${app.rest.api.prefix}/v1")
@Slf4j
public class CurrencyRateController {
    private final CurrencyRateService currencyRateService;
    @GetMapping("/currencyRate/{currency}/{date}")
    public Mono<CurrencyRate> getCurrencyRate(@PathVariable("currency") String currency
            , @DateTimeFormat(pattern = "dd-MM-yyyy") @PathVariable("date")LocalDate date) {
        log.info("getCurrencyRate, currency:{}, date:{}", currency, date);
        CurrencyRate cr = currencyRateService.getCurrencyRate(currency, date);
        log.info("rate:{}", cr);

        return Mono.just(cr);

    }
}

