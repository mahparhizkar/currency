package com.ai724.currency.currencyconversion.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeValueResDto {
    private int id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private int port;
}
