package io.github.carlosthe19916.scriptles.peru.sunat.cpe;


import org.junit.Assert;
import org.junit.Test;

public class TipoDocumentoScriptletTest {

    @Test
    public void testFromCodigo() {
        TipoDocumentoScriptlet scriptlet = new TipoDocumentoScriptlet();

        String tipoDocumento = scriptlet.fromCodigo("00");
        Assert.assertNull(tipoDocumento);

        tipoDocumento = scriptlet.fromCodigo("01");
        Assert.assertEquals("FACTURA", tipoDocumento);
    }

}
