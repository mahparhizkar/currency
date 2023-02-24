package com.ai724.currency.currencyconversion.controller;

import com.ai724.currency.currencyconversion.dto.CurrencyConverterReqDto;
import com.ai724.currency.currencyconversion.dto.ResponseDto;
import com.ai724.currency.currencyconversion.service.CurrencyConversionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CurrencyConversionService currencyConversionService;

    @GetMapping("/currency-converter-feign")
    public ResponseDto retrieveExchangeValue(@RequestBody CurrencyConverterReqDto request) {
        return currencyConversionService.exchangeValue(request);
    }
}
