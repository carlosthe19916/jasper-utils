package io.github.carlosthe19916.finance.internal;

import io.github.carlosthe19916.finance.internal.languages.GenderType;

public interface GenderAwareIntegerToStringConverter {
    String asWords(Integer value, GenderType genderType);
}
