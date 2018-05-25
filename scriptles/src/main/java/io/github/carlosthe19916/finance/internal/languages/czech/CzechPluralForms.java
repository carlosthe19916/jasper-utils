package io.github.carlosthe19916.finance.internal.languages.czech;

import com.google.common.collect.Range;
import io.github.carlosthe19916.finance.internal.languages.GenderType;
import io.github.carlosthe19916.finance.internal.languages.PluralForms;

public class CzechPluralForms implements PluralForms {

    private final String singularForm;
    private final String pluralForm;
    private final String genitivePluralForm;

    private final GenderType genderType;

    public CzechPluralForms(String singularForm, String pluralForm, String genitivePluralForm, GenderType genderType) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genitivePluralForm = genitivePluralForm;

        this.genderType = genderType;
    }

    public CzechPluralForms() {
        this("", "", "", GenderType.NON_APPLICABLE);
    }

    @Override
    public String formFor(Integer value) {
        if (value == 1) {
            return singularForm;
        } else if (Range.closed(2, 4).contains(value)) {
            return pluralForm;
        }

        return genitivePluralForm;
    }

    @Override
    public GenderType genderType() {
        return this.genderType;
    }
}
