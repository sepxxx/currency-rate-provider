package com.bnk.cbrrate.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Builder
public class CurrencyRate {
    String numCode;
    String charCode;
    String nominal;
    String name;
    String value;
//    public static Builder newBuilder() {
//        return new CurrencyRate().new Builder();
//    }

    //Реализация Builder через статический внутренний класс (не потокобезопасная)
//    public class Builder {
//
//        private Builder() {
//            // private constructor
//        }
//
//        public Builder setNumCode(String numCode) {
//            CurrencyRate.this.numCode = numCode;
//            return this;
//        }
//
//        public Builder setNominal(String nominal) {
//            CurrencyRate.this.nominal = nominal;
//            return this;
//        }
//
//        public Builder setCharCode(String charCode) {
//            CurrencyRate.this.charCode = charCode;
//            return this;
//        }
//
//        public Builder setName(String name) {
//            CurrencyRate.this.name = name;
//            return this;
//        }
//
//        public Builder setValue(String value) {
//            CurrencyRate.this.value = value;
//            return this;
//        }
//
//        public CurrencyRate build() {
//            return CurrencyRate.this;
//        }
//
//    }
}
