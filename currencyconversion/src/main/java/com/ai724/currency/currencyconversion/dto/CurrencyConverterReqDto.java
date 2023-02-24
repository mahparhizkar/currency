package com.ai724.currency.currencyconversion.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyConverterReqDto {
    private String from;
    private String to;
    private BigDecimal quantity;
}
