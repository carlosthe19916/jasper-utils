package io.github.carlosthe19916.scriptles;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class FormatNumberScriptletTest {

    @Test
    public void testPattern() {
        Matcher matcher = FormatNumberScriptlet.NUMBER_PATTERN_EXPRESSION.matcher("USD-2,.");
        Assert.assertTrue(matcher.matches());

        matcher = FormatNumberScriptlet.NUMBER_PATTERN_EXPRESSION.matcher("USD");
        Assert.assertTrue(matcher.matches());

        matcher = FormatNumberScriptlet.NUMBER_PATTERN_EXPRESSION.matcher("2");
        Assert.assertTrue(matcher.matches());

        matcher = FormatNumberScriptlet.NUMBER_PATTERN_EXPRESSION.matcher(",.");
        Assert.assertTrue(matcher.matches());

        matcher = FormatNumberScriptlet.NUMBER_PATTERN_EXPRESSION.matcher("USD-2");
        Assert.assertTrue(matcher.matches());

        matcher = FormatNumberScriptlet.NUMBER_PATTERN_EXPRESSION.matcher("USD-,.");
        Assert.assertTrue(matcher.matches());

        matcher = FormatNumberScriptlet.NUMBER_PATTERN_EXPRESSION.matcher("2,.");
        Assert.assertTrue(matcher.matches());
    }

    @Test
    public void testFormatNumber() {
        FormatNumberScriptlet scriptlet = new FormatNumberScriptlet();

        BigDecimal bigDecimal = new BigDecimal("1234.456");

        String number = scriptlet.formatNumber(bigDecimal);
        Assert.assertEquals("1,234.46", number);

        number = scriptlet.formatNumber(bigDecimal, "USD-2,.");
        Assert.assertEquals("USD1,234.46", number);

        number = scriptlet.formatNumber(bigDecimal, "USD");
        Assert.assertEquals("USD1,234.46", number);

        number = scriptlet.formatNumber(bigDecimal, "3");
        Assert.assertEquals("1,234.456", number);

        number = scriptlet.formatNumber(bigDecimal, ",.");
        Assert.assertEquals("1,234.46", number);

        number = scriptlet.formatNumber(bigDecimal, "USD-3");
        Assert.assertEquals("USD1,234.456", number);

        number = scriptlet.formatNumber(bigDecimal, "USD-,.");
        Assert.assertEquals("USD1,234.46", number);

        number = scriptlet.formatNumber(bigDecimal, "3,.");
        Assert.assertEquals("1,234.456", number);
    }

    @Test
    public void testFormatCollection() {
        FormatNumberScriptlet scriptlet = new FormatNumberScriptlet();

        List<BigDecimal> collection = new ArrayList<>();
        collection.add(new BigDecimal("1234.456"));
        collection.add(new BigDecimal("12345.456"));

        String number = scriptlet.mergeCollection(collection);
        Assert.assertEquals("1,234.46 , 12,345.46", number);

        number = scriptlet.mergeCollection(collection, "USD-3,.");
        Assert.assertEquals("USD1,234.456 , USD12,345.456", number);

        number = scriptlet.mergeCollection(collection, "USD-3,.", "|");
        Assert.assertEquals("USD1,234.456 | USD12,345.456", number);
    }

    @Test
    public void testSum() {
        FormatNumberScriptlet scriptlet = new FormatNumberScriptlet();

        List<BigDecimal> collection = new ArrayList<>();
        collection.add(new BigDecimal("900"));
        collection.add(new BigDecimal("200"));

        String sum = scriptlet.sum(collection);
        Assert.assertEquals("1,100.00", sum);

        sum = scriptlet.sum(collection, "USD");
        Assert.assertEquals("USD1,100.00", sum);

        sum = scriptlet.sum(new BigDecimal("900"), new BigDecimal("200"));
        Assert.assertEquals("1,100.00", sum);

        sum = scriptlet.sum("USD", new BigDecimal("900"), new BigDecimal("200"));
        Assert.assertEquals("USD1,100.00", sum);

        sum = scriptlet.sum(collection, new BigDecimal("900"), new BigDecimal("200"));
        Assert.assertEquals("2,200.00", sum);

        sum = scriptlet.sum("USD", collection, new BigDecimal("900"), new BigDecimal("200"));
        Assert.assertEquals("USD2,200.00", sum);
    }

    @Test
    public void testSumNull() {
        FormatNumberScriptlet scriptlet = new FormatNumberScriptlet();

        List<BigDecimal> collection = new ArrayList<>();
        collection.add(null);

        String sum = scriptlet.sum(collection);
        Assert.assertEquals("0.00", sum);
    }
}
