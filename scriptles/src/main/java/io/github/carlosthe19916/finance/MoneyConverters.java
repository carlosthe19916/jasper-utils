package io.github.carlosthe19916.finance;

import io.github.carlosthe19916.finance.internal.BigDecimalToStringConverter;

import java.math.BigDecimal;

import static com.google.common.base.Verify.verifyNotNull;
import static io.github.carlosthe19916.finance.internal.Container.*;

public enum MoneyConverters {

    GERMAN_BANKING_MONEY_VALUE(germanContainer().getBankingMoneyConverter()),
    RUSSIAN_BANKING_MONEY_VALUE(russianContainer().getBankingMoneyConverter()),
    POLISH_BANKING_MONEY_VALUE(polishContainer().getBankingMoneyConverter()),
    CZECH_BANKING_MONEY_VALUE(czechContainer().getBankingMoneyConverter()),
    ENGLISH_BANKING_MONEY_VALUE(englishContainer().getBankingMoneyConverter()),
    SPANISH_BANKING_MONEY_VALUE(spanishContainer().getBankingMoneyConverter());

    private BigDecimalToStringConverter converter;

    private MoneyConverters(BigDecimalToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(BigDecimal value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}
