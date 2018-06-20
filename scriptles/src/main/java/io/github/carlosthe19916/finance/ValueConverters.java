/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package io.github.carlosthe19916.finance;

import io.github.carlosthe19916.finance.internal.IntegerToStringConverter;

import static com.google.common.base.Verify.verifyNotNull;
import static io.github.carlosthe19916.finance.internal.Container.*;

public enum ValueConverters {

    BRAZILIAN_PORTUGUESE_INTEGER(brazilianPortugueseContainer().getNumbersConverter()),
    GERMAN_INTEGER(germanContainer().getNumbersConverter()),
    POLISH_INTEGER(polishContainer().getNumbersConverter()),
    RUSSIAN_INTEGER(russianContainer().getNumbersConverter()),
    CZECH_INTEGER(czechContainer().getNumbersConverter()),
    ENGLISH_INTEGER(englishContainer().getNumbersConverter()),
    SLOVAK_INTEGER(slovakContainer().getNumbersConverter()),
    LATVIAN_INTEGER(latvianContainer().getNumbersConverter()),
    KAZAKH_INTEGER(kazakhContainer().getNumbersConverter()),
    SPANISH_INTEGER(spanishContainer().getNumbersConverter());

    private final IntegerToStringConverter converter;

    ValueConverters(IntegerToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Integer value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}
