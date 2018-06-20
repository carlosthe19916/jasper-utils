package io.github.carlosthe19916.finance.internal.languages.portuguese;

import io.github.carlosthe19916.finance.internal.IntegerToStringConverter;
import io.github.carlosthe19916.finance.internal.converters.IntegerToWordsConverter;
import io.github.carlosthe19916.finance.internal.languages.GenderType;
import io.github.carlosthe19916.finance.internal.languages.PluralForms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PortugueseIntegerToWordsConverterAdapter extends IntegerToWordsConverter {

    public PortugueseIntegerToWordsConverterAdapter(IntegerToStringConverter hundredsToWordsConverter,
             List<PluralForms> pluralForms) {
         super(hundredsToWordsConverter, pluralForms);
    }

    @Override
    protected String joinValueChunksWithForms(Iterator<Integer> chunks, Iterator<PluralForms> formsToUse) {
        List<String> result = new ArrayList<>();

        while (chunks.hasNext() && formsToUse.hasNext()) {
            Integer currentChunkValue = chunks.next();
            PluralForms currentForms = formsToUse.next();

            if (currentChunkValue > 0) {
                result.add(hundredsToWordsConverter.asWords(currentChunkValue, GenderType.NON_APPLICABLE));
                result.add(currentForms.formFor(currentChunkValue));
            }
        }

        return joinParts(result);
    }

}