package io.github.carlosthe19916.scriptles;

import net.sf.jasperreports.engine.JRDefaultScriptlet;

import java.util.Collection;

public class FormatStringScriptlet extends JRDefaultScriptlet {

    public String uppercase(String value) {
        return conditionalCase(value, true);
    }

    public String lowercase(String value) {
        return conditionalCase(value, false);
    }

    public String conditionalCase(String value, boolean toUppercase) {
        if (value != null) {
            value = toUppercase ? value.toUpperCase() : value.toLowerCase();
        }
        return value;
    }

    public String mergeCollection(Collection<String> collection) {
        return mergeCollection(collection, ",");
    }

    public String mergeCollection(Collection<String> collection, String separator) {
        return String.join(separator, collection);
    }

}
