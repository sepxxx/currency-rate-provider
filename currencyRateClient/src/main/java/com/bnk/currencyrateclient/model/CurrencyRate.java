package com.bnk.currencyrateclient.model;


//данная модель будет отличаться от тех, что расположены
//например в cbrRate модуле, тк от другого сервиса- например биржи
//мы не обязательно получим все в таком же формате, нужен общий

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Value
//поля приватные и финальные
//делаются геттеры
//AllArgsConstructor + equals+hashcode
@Builder
public class CurrencyRate {
    String charCode;
    String nominal;
    String value;

    @JsonCreator
    public CurrencyRate(@JsonProperty("charCode") String charCode,
                        @JsonProperty("nominal") String nominal, @JsonProperty("value") String value) {
        this.charCode = charCode;
        this.nominal = nominal;
        this.value = value;
    }

}
