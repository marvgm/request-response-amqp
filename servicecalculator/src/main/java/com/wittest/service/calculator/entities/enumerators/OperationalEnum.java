package com.wittest.service.calculator.entities.enumerators;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum OperationalEnum {
    SUM("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private static final OperationalEnum[] valores = new OperationalEnum[]{SUM, MINUS, MULTIPLICATION, DIVISION};

    private String signo;

    OperationalEnum(String signo) {
        this.signo = signo;
    }

    private String getSigno() {
        return this.signo;
    }

    @JsonCreator
    public static OperationalEnum desdeValor(String valor) {

        for (int i = 0; i < valores.length; ++i) {
            OperationalEnum opActual = valores[i];
            if (valor.equalsIgnoreCase(opActual.name()) ||
                    valor.equalsIgnoreCase(opActual.getSigno())) {
                return opActual;
            }
        }

        throw new RuntimeException("Operación no soportada para el valor: " + valor);
    }

}
