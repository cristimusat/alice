package com.cm.alice.financial.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Currency;

@Getter
@ToString
@Embeddable
@NoArgsConstructor
public class Amount {

    private BigDecimal value;

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
