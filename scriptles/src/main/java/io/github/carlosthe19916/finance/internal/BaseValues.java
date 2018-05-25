package io.github.carlosthe19916.finance.internal;

import io.github.carlosthe19916.finance.internal.languages.GenderForms;
import io.github.carlosthe19916.finance.internal.languages.PluralForms;

import java.util.List;
import java.util.Map;

public interface BaseValues {

    Map<Integer, GenderForms> baseNumbers();

    List<PluralForms> pluralForms();

    String connector();

    String twoDigitsNumberSeparator();
}
