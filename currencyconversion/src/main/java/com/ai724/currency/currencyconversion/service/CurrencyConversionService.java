package com.ai724.currency.currencyconversion.service;

import com.ai724.currency.currencyconversion.common.CustomModelMapper;
import com.ai724.currency.currencyconversion.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionService {

    private final CustomModelMapper modelMapper = new CustomModelMapper();

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    public ResponseDto exchangeValue(CurrencyConverterReqDto request) {
        ResponseDto response = new ResponseDto();

        ExchangeValueReqDto exchangeValueReqDto = new ExchangeValueReqDto();
        exchangeValueReqDto.setFrom(request.getFrom());
        exchangeValueReqDto.setTo(request.getTo());
        ResponseDto responseDto = proxy.exchangeValue(exchangeValueReqDto);
        if (responseDto.getStatus() != 0) {
            response.setStatus(-1);
            response.setMessage("NOT_FOUND_RECORD_FROM_FOREX");
            return response;
        }

        ExchangeValueResDto exchangeValueResDto = modelMapper.map(responseDto.getResultData(), ExchangeValueResDto.class);

        CurrencyConversionResDto currencyConversionResDto = new CurrencyConversionResDto();
        currencyConversionResDto.setId(exchangeValueResDto.getId());
        currencyConversionResDto.setFrom(exchangeValueReqDto.getFrom());
        currencyConversionResDto.setTo(exchangeValueReqDto.getTo());
        currencyConversionResDto.setPort(exchangeValueResDto.getPort());
        currencyConversionResDto.setQuantity(request.getQuantity());
        currencyConversionResDto.setConversionMultiple(exchangeValueResDto.getConversionMultiple());
        currencyConversionResDto.setTotalCalculatedAmount(request.getQuantity().multiply(exchangeValueResDto.getConversionMultiple()));

        response.setResultData(currencyConversionResDto);
        response.setStatus(0);
        response.setMessage("SUCCESS");
        return response;
    }

}
