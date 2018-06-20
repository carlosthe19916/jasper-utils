package io.github.carlosthe19916.finance.internal;

public class ToStringConverter {

    public static GenderAwareIntegerToStringConverter toGenderAwareInteger(final IntegerToStringConverter integerToStringConverter) {
        return (value, genderType) -> integerToStringConverter.asWords(value);
    }
}
