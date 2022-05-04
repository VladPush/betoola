package com.code.ms.service;

import com.code.ms.dto.CurrencyType;
import com.code.ms.dto.ExchangeType;
import com.code.ms.entity.ExchangeRate;
import com.code.ms.repository.ExchangeRateRepository;
import com.code.ms.utils.CurrencyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.code.ms.dto.ExchangeType.BUY_TICKET;
import static com.code.ms.dto.ExchangeType.SELL_TO_TICKET;

@Service
public class CurrencyExchangeService {

    private final ExchangeRateRepository exchangeRateRepository;

    private final BigDecimal multiplicand;

    public CurrencyExchangeService(ExchangeRateRepository exchangeRateRepository,
                                   @Value("${exchange.margin}") BigDecimal margin) {
        this.exchangeRateRepository = exchangeRateRepository;
        this.multiplicand = BigDecimal.valueOf(1 + margin.movePointLeft(2).doubleValue());
    }

    public BigDecimal buyTicket(CurrencyType numerator, CurrencyType denominator, BigDecimal value) {
        return exchange(numerator, denominator, value, BUY_TICKET);
    }

    public BigDecimal sellToTicket(CurrencyType numerator, CurrencyType denominator, BigDecimal value) {
        return exchange(numerator, denominator, value, SELL_TO_TICKET);
    }

    public BigDecimal exchange(CurrencyType numerator, CurrencyType denominator, BigDecimal value, ExchangeType exchangeType) {
        ExchangeRate exchangeRate = exchangeRateRepository.findByNumeratorAndDenominator(numerator, denominator);
        BigDecimal rate = exchangeRate.getRate();
        BigDecimal result;

        if (exchangeType.equals(SELL_TO_TICKET)) {
            result = value.divide(rate, CurrencyUtils.DEFAULT_ROUNDING_MODE)
                    .divide(multiplicand, CurrencyUtils.DEFAULT_ROUNDING_MODE);
        } else if (exchangeType.equals(BUY_TICKET)) {
            result = rate.multiply(value)
                    .multiply(multiplicand);
        } else {
            throw new RuntimeException(); // some clear exception
        }
        return CurrencyUtils.defaultScale(result);
    }
}
