package io.github.carlosthe19916.finance.internal.languages.czech;

import io.github.carlosthe19916.finance.internal.IntegerToStringConverter;
import io.github.carlosthe19916.finance.internal.NumberProcessor;

import java.util.Map;

public class CzechIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter bigNumbersConverter;
    private final IntegerToStringConverter smallNumbersConverter;
    private final Map<Integer, String> exceptions;

    public CzechIntegerToWordsConverter(IntegerToStringConverter bigNumbersConverter,
                                        IntegerToStringConverter smallNumbersConverter,
                                        Map<Integer, String> exceptions) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.smallNumbersConverter = smallNumbersConverter;
        this.exceptions = exceptions;
    }

    @Override
    public String asWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value);
        }

        Integer bigNumber = value / 1000;
        Integer smallNumber = value % 1000;

        return new NumberProcessor(bigNumbersConverter, smallNumbersConverter).process(bigNumber, smallNumber);
    }
}
