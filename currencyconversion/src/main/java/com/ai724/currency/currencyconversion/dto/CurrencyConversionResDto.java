package com.ai724.currency.currencyconversion.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyConversionResDto {
    private int id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private int port;
}
