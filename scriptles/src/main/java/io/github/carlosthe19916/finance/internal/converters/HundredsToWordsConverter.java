package io.github.carlosthe19916.finance.internal.converters;

import com.google.common.collect.Range;
import io.github.carlosthe19916.finance.internal.GenderAwareIntegerToStringConverter;
import io.github.carlosthe19916.finance.internal.languages.GenderForms;
import io.github.carlosthe19916.finance.internal.languages.GenderType;

import java.util.Map;

import static java.lang.String.format;

public class HundredsToWordsConverter implements GenderAwareIntegerToStringConverter {

    private final Map<Integer, GenderForms> baseValues;
    private final char twoDigitsNumberSeparator;

    public HundredsToWordsConverter(Map<Integer, GenderForms> baseValues, char twoDigitsNumberSeparator) {
        this.baseValues = baseValues;
        this.twoDigitsNumberSeparator = twoDigitsNumberSeparator;
    }

    @Override
    public String asWords(Integer value, GenderType genderType) {
        if (baseValues.containsKey(value)) {
            return baseValues.get(value).formFor(genderType);
        } else if (Range.closed(21, 99).contains(value)) {
            return twoDigitsNumberAsString(value, genderType);
        } else if (Range.closed(101, 999).contains(value)) {
            return threeDigitsNumberAsString(value, genderType);
        }

        throw new IllegalArgumentException(format("Can't convert %d", value));
    }

    private String twoDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer units = value % 10;
        Integer tens = value - units;
        return format("%s%c%s", asWords(tens, genderType), twoDigitsNumberSeparator, asWords(units, genderType));
    }

    private String threeDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        return format("%s %s", asWords(hundreds, genderType), asWords(tensWithUnits, genderType));
    }
}
