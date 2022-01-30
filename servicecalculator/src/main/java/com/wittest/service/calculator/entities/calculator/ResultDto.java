package com.wittest.service.calculator.entities.calculator;

import java.math.BigDecimal;
import java.util.UUID;

public class ResultDto {
    private UUID id;
    private BigDecimal result;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }
}
