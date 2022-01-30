package com.wittest.api.bff.calculator.entities;

import java.math.BigDecimal;
import java.util.UUID;

public class ProducerDto {
    private UUID id;
    private BigDecimal a;
    private BigDecimal b;
    private String opec;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getA() {
        return a;
    }

    public void setA(BigDecimal a) {
        this.a = a;
    }

    public BigDecimal getB() {
        return b;
    }

    public void setB(BigDecimal b) {
        this.b = b;
    }

    public String getOpec() {
        return opec;
    }

    public void setOpec(String opec) {
        this.opec = opec;
    }
}
