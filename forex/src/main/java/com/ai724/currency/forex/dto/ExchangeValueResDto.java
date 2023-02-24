package com.ai724.currency.forex.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExchangeValueResDto {
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private int port;
}
