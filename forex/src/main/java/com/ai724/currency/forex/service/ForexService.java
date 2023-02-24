package com.ai724.currency.forex.service;

import com.ai724.currency.forex.common.CustomModelMapper;
import com.ai724.currency.forex.dto.ExchangeValueReqDto;
import com.ai724.currency.forex.dto.ExchangeValueResDto;
import com.ai724.currency.forex.dto.ResponseDto;
import com.ai724.currency.forex.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ForexService {

    @Value("${server.port}")
    private int localPort;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    private final CustomModelMapper modelMapper = new CustomModelMapper();

    public ResponseDto exchangeValue(ExchangeValueReqDto request) {
        ResponseDto response = new ResponseDto();
        ExchangeValueResDto exchangeValueResDto = modelMapper.map(exchangeValueRepository.findByFromAndTo(request.getFrom(), request.getTo()), ExchangeValueResDto.class);
        if (exchangeValueResDto == null) {
            response.setStatus(-1);
            response.setMessage("NOT_FOUND_RECORD");
            return response;
        }

        exchangeValueResDto.setPort(localPort);
        response.setResultData(exchangeValueResDto);
        response.setStatus(0);
        response.setMessage("SUCCESS");
        return response;
    }
}
