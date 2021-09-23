package com.cm.alice.financial.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@Getter
@ToString
@Embeddable
public class Amount {

    @NonNull
    private BigDecimal value;

    @NonNull
    private Currency currency;

    public Amount(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public Amount(double value, String currencyCode) {
        this(BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_EVEN), Currency.getInstance(currencyCode));
    }

    public static Amount of(double value, String currencyCode) {
        return new Amount(value, currencyCode);
    }
}
