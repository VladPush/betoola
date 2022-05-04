package com.code.ms.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "client_money_purse")
@Entity
@Getter
@Setter
public class ClientMoneyPurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "money_value")
    private BigDecimal moneyValue;
}
