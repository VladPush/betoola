package com.code.ms.service;

import com.code.ms.dto.CurrencyType;
import com.code.ms.dto.exception.InsufficientBalance;
import com.code.ms.entity.ClientMoneyPurse;
import com.code.ms.repository.MoneyStorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.code.ms.dto.CurrencyType.EUR;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final MoneyStorageRepository moneyStorageRepository;
    private final CurrencyExchangeService currencyExchangeService;

    public BigDecimal buyTicket(long clientId, CurrencyType ticket, BigDecimal value) {
        ClientMoneyPurse clientMoneyPurse = moneyStorageRepository.getById(clientId);
        BigDecimal result = currencyExchangeService.buyTicket(ticket, EUR, value);
        balanceCheck(clientMoneyPurse.getMoneyValue(), result);
        return result;
    }

    public BigDecimal sellToTicket(long clientId, CurrencyType ticket, BigDecimal value) {
        ClientMoneyPurse clientMoneyPurse = moneyStorageRepository.getById(clientId);
        balanceCheck(clientMoneyPurse.getMoneyValue(), value);
        return currencyExchangeService.sellToTicket(ticket, EUR, value);
    }

    private void balanceCheck(BigDecimal currentValue, BigDecimal requiredValue) {
        if (currentValue.compareTo(requiredValue) < 0) {
            throw new InsufficientBalance("Insufficient funds on the account");
        }
    }
}
