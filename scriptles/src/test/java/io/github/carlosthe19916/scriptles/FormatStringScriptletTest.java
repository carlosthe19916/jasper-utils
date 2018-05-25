package io.github.carlosthe19916.scriptles;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FormatStringScriptletTest {


    @Test
    public void testUppercase() {
        FormatStringScriptlet scriptlet = new FormatStringScriptlet();

        String value = scriptlet.uppercase(null);
        Assert.assertNull(value);
        value = scriptlet.uppercase("hola");
        Assert.assertEquals("HOLA", value);

        value = scriptlet.lowercase(null);
        Assert.assertNull(value);
        value = scriptlet.lowercase("HOLA");
        Assert.assertEquals("hola", value);

        value = scriptlet.conditionalCase("hola", true);
        Assert.assertEquals("HOLA", value);
        value = scriptlet.conditionalCase("HOLA", false);
        Assert.assertEquals("hola", value);
    }

    @Test
    public void testMergeCollection() {
        FormatStringScriptlet scriptlet = new FormatStringScriptlet();

        List<String> collection = new ArrayList<>();
        collection.add("Hola");
        collection.add("carlos");
        collection.add("esteban");

        String value = scriptlet.mergeCollection(collection);
        Assert.assertEquals("Hola,carlos,esteban", value);

        value = scriptlet.mergeCollection(collection, "|");
        Assert.assertEquals("Hola|carlos|esteban", value);
    }
}
