package io.github.carlosthe19916.finance.internal.languages.german;

import io.github.carlosthe19916.finance.internal.GenderAwareIntegerToStringConverter;
import io.github.carlosthe19916.finance.internal.IntegerToStringConverter;
import io.github.carlosthe19916.finance.internal.NumberProcessor;

import java.util.Map;

public class GermanIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter bigNumbersConverter;
    private final Map<Integer, String> exceptions;
    private final GenderAwareIntegerToStringConverter smallNumbersConverter;

    public GermanIntegerToWordsConverter(IntegerToStringConverter bigNumbersConverter,
                                         Map<Integer, String> exceptions,
                                         GenderAwareIntegerToStringConverter smallNumbersConverter) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.exceptions = exceptions;
        this.smallNumbersConverter = smallNumbersConverter;
    }

    @Override
    public String asWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value);
        }

        Integer bigNumber = value / 1000000;
        Integer smallNumber = value % 1000000;

        return new NumberProcessor(bigNumbersConverter, smallNumbersConverter).process(bigNumber, smallNumber);
    }

}
