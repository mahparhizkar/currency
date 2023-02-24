package com.ai724.currency.currencyconversion.service;

import com.ai724.currency.currencyconversion.dto.ExchangeValueReqDto;
import com.ai724.currency.currencyconversion.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="forex-service", url="localhost:8000")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange")
    ResponseDto exchangeValue(@RequestBody ExchangeValueReqDto request);
}
