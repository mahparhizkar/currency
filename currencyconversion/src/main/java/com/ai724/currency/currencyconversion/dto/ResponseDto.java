package com.ai724.currency.currencyconversion.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private int status;
    private String message;
    private Object resultData;
}
