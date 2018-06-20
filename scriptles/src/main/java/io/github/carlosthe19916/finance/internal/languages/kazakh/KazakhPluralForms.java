package io.github.carlosthe19916.finance.internal.languages.kazakh;

import io.github.carlosthe19916.finance.internal.languages.GenderType;
import io.github.carlosthe19916.finance.internal.languages.PluralForms;

public class KazakhPluralForms implements PluralForms {

    private String form;

    public KazakhPluralForms(String form) {
        this.form = form;
    }

    @Override
    public String formFor(Integer value) {
        return form;
    }

    @Override
    public GenderType genderType() {
        return GenderType.NON_APPLICABLE;
    }
}
