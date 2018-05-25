package io.github.carlosthe19916.scriptles.peru.sunat.cpe;

import java.util.Optional;
import java.util.stream.Stream;

public enum TipoDocumento {

    FACTURA("01", "FACTURA"),
    BOLETA("03", "BOLETA"),
    NOTA_CREDITO("07", "NOTA DE CREDITO"),
    NOTA_DEBITO("08", "NOTA DE DEBITO"),
    GUIA_REMITENTE("09", "GUIA DE REMISIÓN REMITENTE"),
    TICKET("12", "TICKET DE MAQUINA REGISTRADORA"),
    DOCUMENTO_FINANCIERA("13", "DOCUMENTO EMITIDO POR BANCOS, INSTITUCIONES FINANCIERAS, CREDITICIAS Y DE SEGUROS QUE SE ENCUENTREN BAJO EL CONTROL DE LA SUPERINTENDENCIA DE BANCA Y SEGUROS"),
    RECIBO("14", "RECIBO SERVICIOS PUBLICOS"),
    AFP("18", "DOCUMENTOS EMITIDOS POR LAS AFP"),
    RETENCION("20", "RETENCION ELECTRONICA"),
    GUIA_TRANSPORTISTA("31", "GUIA DE REMISIÓN TRANSPORTISTA"),
    PERCEPCION("40", "PERCEPCION ELECTRONICA"),
    GUIA_SEAE("56", "COMPROBANTE DE PAGO SEAE"),
    GUIA_REMITENTE_COMPLEMENTARIA("71", "GUIA DE REMISIÓN REMITENTE COMPLEMENTARIA"),
    GUIA_TRANSPORTISTA_COMPLEMENTARIA("72", "GUIA DE REMISION TRANSPORTISTA COMPLEMENTARIA");

    private final String codigo;
    private final String denominacion;

    TipoDocumento(String codigo, String denominacion) {
        this.codigo = codigo;
        this.denominacion = denominacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public static Optional<TipoDocumento> searchByCodigo(String codigo) {
        return Stream.of(TipoDocumento.values()).filter(p -> p.getCodigo().equals(codigo)).findFirst();
    }
}
