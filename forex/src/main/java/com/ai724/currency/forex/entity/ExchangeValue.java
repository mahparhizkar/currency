package com.ai724.currency.forex.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "EXCHANGE_VALUE")
@Entity
@Data
public class ExchangeValue {

    @Id
    private Long id;

    @Column(name="currency_from")
    private String from;

    @Column(name="currency_to")
    private String to;

    @Column(name="conversion_multiple")
    private BigDecimal conversionMultiple;

    private int port;
}
