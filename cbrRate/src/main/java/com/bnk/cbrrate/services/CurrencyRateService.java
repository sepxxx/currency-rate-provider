package com.bnk.cbrrate.services;

import com.bnk.cbrrate.config.CbrConfig;
import com.bnk.cbrrate.model.CurrencyRate;
import com.bnk.cbrrate.model.CurrencyRates;
import com.bnk.cbrrate.parser.CurrencyRateParser;
import com.bnk.cbrrate.requester.CbrRequester;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.ehcache.Cache;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyRateService {
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);


    private final CbrRequester cbrRequester;
    private final CurrencyRateParser currencyRateParser;
    private final Cache<LocalDate, CurrencyRates> currencyRatesCache;
    private final CbrConfig cbrConfig;

    public CurrencyRate getCurrencyRate(String currency, LocalDate date) {
        //проверить кеш и достать
        //если пустой
        //нужно сформировать ссылку по дате до цбр сайта
        //распарсить хмл
        //из списка вытащить нужную валюту
        List<CurrencyRate> rates;
        CurrencyRates cachedCurrencyRates = currencyRatesCache.get(date);
        if(cachedCurrencyRates==null) {
            String urlWithParams = String.format("%s?date_req=%s", cbrConfig.getUrl(), DATE_FORMATTER.format(date));
            String ratesAsXml = cbrRequester.getRatesAsXml(urlWithParams);
            rates = currencyRateParser.parse(ratesAsXml);
        } else {
            rates = cachedCurrencyRates.getCurrencyRates();
        }
        return rates.stream().filter(rate->rate.getCharCode().equals(currency))
                .findFirst()
                .orElseThrow();
    }
}
