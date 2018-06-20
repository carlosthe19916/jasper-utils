package io.github.carlosthe19916.finance.internal.languages.portuguese;

import io.github.carlosthe19916.finance.internal.IntegerToStringConverter;
import io.github.carlosthe19916.finance.internal.MultiFormNumber;
import io.github.carlosthe19916.finance.internal.NumberProcessor;

import java.util.Map;

public class PortugueseIntegerToWordsConverter implements IntegerToStringConverter {

    private final IntegerToStringConverter bigNumbersConverter;
    private final Map<Integer, MultiFormNumber> exceptions;
    private final IntegerToStringConverter smallNumbersConverter;

    public PortugueseIntegerToWordsConverter(IntegerToStringConverter bigNumbersConverter,
                                         Map<Integer, MultiFormNumber> exceptions,
                                         IntegerToStringConverter smallNumbersConverter) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.exceptions = exceptions;
        this.smallNumbersConverter = smallNumbersConverter;
    }

    @Override
    public String asWords(Integer value) {
        if (exceptions.containsKey(value)) {
            return exceptions.get(value).getAloneForm();
        }

        Integer bigNumber = value / 1000000;
        Integer smallNumber = value % 1000000;

        return new NumberProcessor(bigNumbersConverter, smallNumbersConverter).process(bigNumber, smallNumber);
    }
}
