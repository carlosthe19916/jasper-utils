package io.github.carlosthe19916.finance.internal.languages.slovak;

import io.github.carlosthe19916.finance.internal.BaseValues;
import io.github.carlosthe19916.finance.internal.languages.GenderForms;
import io.github.carlosthe19916.finance.internal.languages.GenderType;
import io.github.carlosthe19916.finance.internal.languages.PluralForms;
import io.github.carlosthe19916.finance.internal.languages.czech.CzechPluralForms;

import java.util.List;
import java.util.Map;

import static io.github.carlosthe19916.finance.internal.languages.GenderForms.genderForm;
import static java.util.Collections.singletonList;

public class SlovakValuesForSmallNumbers implements BaseValues {

    private final SlovakValues originalValues = new SlovakValues();

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        Map<Integer, GenderForms> baseNumbers = originalValues.baseNumbers();
        baseNumbers.put(1, genderForm(baseNumbers.get(1).formFor(GenderType.FEMININE)));
        baseNumbers.put(2, genderForm(baseNumbers.get(2).formFor(GenderType.MASCULINE)));
        return baseNumbers;
    }

    @Override
    public List<PluralForms> pluralForms() {
        return singletonList(new CzechPluralForms());
    }

    @Override
    public String currency() {
        return originalValues.currency();
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }
}
