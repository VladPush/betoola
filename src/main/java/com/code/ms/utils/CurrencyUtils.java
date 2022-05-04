package com.code.ms.utils;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.math.RoundingMode;

@UtilityClass
public class CurrencyUtils {

    /**
     * "Banker's rounding"
     * But in U.S. Federal Tax returns specify to round off to whole dollar amounts using HALF_UP.
     */
    public RoundingMode DEFAULT_ROUNDING_MODE = RoundingMode.HALF_EVEN;

    public BigDecimal defaultScale(BigDecimal value) {
        return value.setScale(2, DEFAULT_ROUNDING_MODE);
    }
}
