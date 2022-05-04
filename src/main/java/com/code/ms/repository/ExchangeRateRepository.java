package com.code.ms.repository;

import com.code.ms.dto.CurrencyType;
import com.code.ms.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {

    ExchangeRate findByNumeratorAndDenominator(CurrencyType numerator, CurrencyType denominator);
}
