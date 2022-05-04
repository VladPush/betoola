package com.code.ms.controller;

import com.code.ms.dto.CurrencyType;
import com.code.ms.service.ExchangeService;
import com.code.ms.utils.CurrencyUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * comment to api: it is assumed that the main currency is one, and this is the EUR
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/exchange/strict-quantity")
public class ExchangeController {

    private final ExchangeService exchangeService;

    // Client wants to buy 100.00 GBP by selling some EUR.
    @GetMapping("/buy/{clientId}/{ticket}")
    public BigDecimal buyTicketAmount(@PathVariable long clientId,
                                      @PathVariable CurrencyType ticket,
                                      @RequestParam BigDecimal value) {
        return exchangeService.buyTicket(clientId, ticket, CurrencyUtils.defaultScale(value));
    }

    //  Client wants to buy some GBP by selling 100.00 EUR.
    @GetMapping("/sell/{clientId}/{ticket}")
    public BigDecimal sellToTicketAmount(@PathVariable long clientId,
                                         @PathVariable CurrencyType ticket,
                                         @RequestParam BigDecimal value) {
        return exchangeService.sellToTicket(clientId, ticket, CurrencyUtils.defaultScale(value));
    }


}
