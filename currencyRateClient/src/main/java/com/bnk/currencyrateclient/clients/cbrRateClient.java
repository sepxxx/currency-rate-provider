package com.bnk.currencyrateclient.clients;

import com.bnk.currencyrateclient.config.CbrRateClientConfig;
import com.bnk.currencyrateclient.model.CurrencyRate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Service("cbr")
@RequiredArgsConstructor
@Slf4j
public class cbrRateClient implements RateClient{
    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
            .ofPattern(DATE_FORMAT);
    private final httpClientJdk httpClient;
    private final ObjectMapper objectMapper;
    private final CbrRateClientConfig cbrRateClientConfig;

    @Override
    public CurrencyRate getCurrencyRate(String currency, LocalDate date) {
        log.info("getCurrencyRate currency:{}, date:{}", currency, date);
        String urlWithParams = String.format("%s/%s/%s", cbrRateClientConfig.getUrl(),
                currency, DATE_TIME_FORMATTER.format(date));

        String response = httpClient.performRequest(urlWithParams);
        try {
            return objectMapper.readValue(response, CurrencyRate.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
