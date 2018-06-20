package io.github.carlosthe19916.finance.internal.languages.slovak;

import com.google.common.collect.ImmutableMap;
import io.github.carlosthe19916.finance.internal.BaseValues;
import io.github.carlosthe19916.finance.internal.languages.GenderForms;
import io.github.carlosthe19916.finance.internal.languages.GenderType;
import io.github.carlosthe19916.finance.internal.languages.PluralForms;
import io.github.carlosthe19916.finance.internal.languages.czech.CzechPluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.github.carlosthe19916.finance.internal.languages.GenderForms.genderForms;
import static io.github.carlosthe19916.finance.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

public class SlovakValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "nula")
                .put(1, genderForms("jeden", "jedna", "jedno"))
                .put(2, genderForms("dva", "dve", "dve"))
                .put(3, "tri")
                .put(4, "štyri")
                .put(5, "päť")
                .put(6, "šesť")
                .put(7, "sedem")
                .put(8, "osem")
                .put(9, "deväť")
                .put(10, "desať")
                .put(11, "jedenásť")
                .put(12, "dvanásť")
                .put(13, "trinásť")
                .put(14, "štrnásť")
                .put(15, "pätnásť")
                .put(16, "šestnásť")
                .put(17, "sedemnásť")
                .put(18, "osemnásť")
                .put(19, "devätnásť")
                .put(20, "dvadsať")
                .put(30, "tridsať")
                .put(40, "štyridsať")
                .put(50, "päťdesiat")
                .put(60, "šesťdesiat")
                .put(70, "sedemdesiat")
                .put(80, "osemdesiat")
                .put(90, "deväťdesiat")
                .put(100, "sto")
                .put(200, "dvesto")
                .put(300, "tristo")
                .put(400, "štyristo")
                .put(500, "päťsto")
                .put(600, "šesťsto")
                .put(700, "sedemsto")
                .put(800, "osemsto")
                .put(900, "deväťsto")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.asList(
                new CzechPluralForms("tisíc", "tisíce", "tisíc", GenderType.MASCULINE),
                new CzechPluralForms("milión", "milióny", "miliónov", GenderType.MASCULINE),
                new CzechPluralForms("miliarda", "miliardy", "miliard", GenderType.FEMININE));
    }

    @Override
    public String currency() {
        return "€";
    }

    @Override
    public char twoDigitsNumberSeparator() {
        return ' ';
    }

    public Map<Integer, String> exceptions() {
        return ImmutableMap.<Integer, String>builder().put(2, "dve").build();
    }
}
