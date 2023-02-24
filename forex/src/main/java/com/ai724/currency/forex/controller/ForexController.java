package com.ai724.currency.forex.controller;

import com.ai724.currency.forex.dto.ExchangeValueReqDto;
import com.ai724.currency.forex.dto.ResponseDto;
import com.ai724.currency.forex.service.ForexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

    @Autowired
    private ForexService forexService;

    @PostMapping("/currency-exchange")
    public ResponseDto retrieveExchangeValue(@RequestBody ExchangeValueReqDto request) {
        return forexService.exchangeValue(request);
    }
}
