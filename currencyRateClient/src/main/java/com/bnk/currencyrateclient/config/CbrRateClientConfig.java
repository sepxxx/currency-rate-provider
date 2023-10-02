package com.bnk.currencyrateclient.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
// @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
@ConfigurationProperties(prefix = "cbr-rate-client")
public class CbrRateClientConfig {
    private String url;
}
