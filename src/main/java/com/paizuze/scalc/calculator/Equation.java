package com.paizuze.scalc.calculator;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Equation {
    private BigDecimal leftOperand;
    private BigDecimal rightOperand;
}
