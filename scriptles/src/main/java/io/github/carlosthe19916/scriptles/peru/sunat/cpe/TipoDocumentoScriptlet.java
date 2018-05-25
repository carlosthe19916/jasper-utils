package io.github.carlosthe19916.scriptles.peru.sunat.cpe;

import net.sf.jasperreports.engine.JRDefaultScriptlet;

public class TipoDocumentoScriptlet extends JRDefaultScriptlet {

    public String fromCodigo(String codigo) {
        return TipoDocumento.searchByCodigo(codigo).map(TipoDocumento::getDenominacion).orElse(null);
    }

}
