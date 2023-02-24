package com.ai724.currency.currencyconversion.common;

import org.modelmapper.ModelMapper;

public class CustomModelMapper extends ModelMapper {

    @Override
    public <D> D map(Object source, Class<D> destinationType)
    {
        if (source == null)
            return null;

        return super.map(source, destinationType);
    }
}
