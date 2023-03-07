package com.example.chapter02.domain;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Getter
public class PriceUnit {
    private final Locale locale;

    public PriceUnit(Locale locale) {
        if (Objects.isNull(locale)){
            throw new IllegalArgumentException("locale arg is null");
        }
        this.locale = locale;
    }

    /**
     * @param price
     * price를 적합한 화폐 포맷으로 변경
     */
    public String format(BigDecimal price) {
        // NumberFormat 클래스는 숫자를 파싱하거나 포매팅한다.
        // thread-safe하지 않아 매번 생성
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
        return currencyFormat.format(
                Optional.ofNullable(price).orElse(BigDecimal.ZERO)
        );
    }

    /**
     * locale이 null 되지 않도록 예외처리
     *
     */
    public void validate() {
        if (Objects.isNull(locale)){
            throw new IllegalArgumentException("locale arg is null");
        }

        log.info("locale is [{}]",locale);
    }
}
