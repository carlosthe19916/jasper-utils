package io.github.carlosthe19916.scriptles.peru.sunat.cpe;

import io.github.carlosthe19916.finance.MoneyConverters;
import net.sf.jasperreports.engine.JRDefaultScriptlet;

import java.math.BigDecimal;

public class MoneyScriptlet extends JRDefaultScriptlet {

    public String asWords(BigDecimal number) {
        if (number == null) {
            return null;
        }

        return MoneyConverters.SPANISH_BANKING_MONEY_VALUE.asWords(number).toUpperCase();
    }

}
