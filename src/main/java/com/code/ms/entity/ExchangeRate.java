package com.code.ms.entity;

import com.code.ms.dto.CurrencyType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "exchange_rate")
@Entity
@Getter
@Setter
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "numerator")
    private CurrencyType numerator;

    @Enumerated(EnumType.STRING)
    @Column(name = "denominator")
    private CurrencyType denominator;

    @Column(name = "rate")
    private BigDecimal rate;
}
