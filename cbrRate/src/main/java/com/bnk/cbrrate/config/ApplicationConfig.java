package com.bnk.cbrrate.config;

import com.bnk.cbrrate.model.CurrencyRate;
import com.bnk.cbrrate.model.CurrencyRates;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class ApplicationConfig {
    private final CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true);

    @Bean
    public Cache<LocalDate, CurrencyRates> currencyRateCache(@Value("${app.cache.size}") int cacheSize) {
        return cacheManager.createCache("CurrencyRate-Cache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(LocalDate.class, CurrencyRates.class,
                                ResourcePoolsBuilder.heap(cacheSize))
                        .build());
    }
}
