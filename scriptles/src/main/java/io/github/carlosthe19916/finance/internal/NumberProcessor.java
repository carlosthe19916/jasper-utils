package io.github.carlosthe19916.finance.internal;

import com.google.common.base.Joiner;
import io.github.carlosthe19916.finance.internal.languages.GenderType;

import java.util.ArrayList;
import java.util.List;

public class NumberProcessor {

    private final IntegerToStringConverter bigNumbersConverter;
    private final GenderAwareIntegerToStringConverter smallNumbersConverter;

    public NumberProcessor(IntegerToStringConverter bigNumbersConverter,
            IntegerToStringConverter smallNumbersConverter) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.smallNumbersConverter = ToStringConverter.toGenderAwareInteger(smallNumbersConverter);
    }

    public NumberProcessor(IntegerToStringConverter bigNumbersConverter,
            GenderAwareIntegerToStringConverter smallNumbersConverter) {
        this.bigNumbersConverter = bigNumbersConverter;
        this.smallNumbersConverter = smallNumbersConverter;
    }

    public String process(Integer bigNumber, Integer smallNumber) {
        List<String> result = new ArrayList<>();

        if (bigNumber > 0) {
            result.add(bigNumbersConverter.asWords(bigNumber));
        }

        if (smallNumber > 0) {
            result.add(smallNumbersConverter.asWords(smallNumber, GenderType.NON_APPLICABLE));
        }

        return merge(result);
    }

    private String merge(List<String> result) {
        if (result.isEmpty()) {
            return smallNumbersConverter.asWords(0, GenderType.NON_APPLICABLE);
        }

        return Joiner.on(" ").join(result);
    }

}
