package io.github.carlosthe19916.scriptles;

import net.sf.jasperreports.engine.JRDefaultScriptlet;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FormatNumberScriptlet extends JRDefaultScriptlet {

    public static final Pattern NUMBER_PATTERN_EXPRESSION = Pattern.compile("([a-zA-Z]{0,9})-?([0-9])?(.)?(.)?");
    private static final String DEFAULT_PATTERN = "2,.";

    public String formatNumber(Number number) {
        return formatNumber(number, DEFAULT_PATTERN);
    }

    public String formatNumber(Number number, String pattern) {
        if (number == null) {
            number = 0;
        }

        Matcher matcher = NUMBER_PATTERN_EXPRESSION.matcher(pattern);
        if (matcher.matches()) {
            String currency = Optional.ofNullable(matcher.group(1)).orElse("");
            int numberOfDecimals = Integer.parseInt(Optional.ofNullable(matcher.group(2)).orElse("2"));
            String firstSeparator = Optional.ofNullable(matcher.group(3)).orElse(",");
            String secondSeparator = Optional.ofNullable(matcher.group(4)).orElse(".");

            NumberFormat formatNumber = NumberFormat.getCurrencyInstance();

            DecimalFormat decimalFormat = (DecimalFormat) formatNumber;
            decimalFormat.setMinimumFractionDigits(numberOfDecimals);
            decimalFormat.setMaximumFractionDigits(numberOfDecimals);

            DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) formatNumber).getDecimalFormatSymbols();
            decimalFormatSymbols.setGroupingSeparator(firstSeparator.toCharArray()[0]);
            decimalFormatSymbols.setDecimalSeparator(secondSeparator.toCharArray()[0]);
            decimalFormatSymbols.setCurrencySymbol(currency);

            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);

            return formatNumber.format(number);
        } else {
            throw new IllegalArgumentException("Pattern doesn't match regular expression:" + NUMBER_PATTERN_EXPRESSION);
        }
    }

    public String mergeCollection(Collection<? extends Number> numbers) {
        return mergeCollection(numbers, ",");
    }

    public String mergeCollection(Collection<? extends Number> numbers, String pattern) {
        return mergeCollection(numbers, pattern, ",");
    }

    public String mergeCollection(Collection<? extends Number> numbers, String pattern, String separator) {
        return numbers.stream()
                .map(number -> formatNumber(number, pattern))
                .collect(Collectors.joining(" " + separator + " "));
    }

    public String sum(List<BigDecimal> collection) {
        return sum(collection, DEFAULT_PATTERN);
    }

    public String sum(List<BigDecimal> collection, String pattern) {
        BigDecimal sum = collection.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return formatNumber(sum, pattern);
    }

    public String sum(BigDecimal... number) {
        return sum(DEFAULT_PATTERN, number);
    }

    public String sum(String pattern, BigDecimal... number) {
        BigDecimal result = Stream.of(number).reduce(BigDecimal.ZERO, BigDecimal::add);
        return formatNumber(result, pattern);
    }

    public String sum(List<BigDecimal> collection, BigDecimal... number) {
        return sum(DEFAULT_PATTERN, collection, number);
    }

    public String sum(String pattern, List<BigDecimal> collection, BigDecimal... number) {
        BigDecimal result = Stream.concat(collection.stream(), Stream.of(number)).reduce(BigDecimal.ZERO, BigDecimal::add);
        return formatNumber(result, pattern);
    }

}
