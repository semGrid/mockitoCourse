package com.griddynamics.transfer.domain;

import java.math.BigDecimal;

public class Recipient {

    private BigDecimal total;

    private BigDecimal commission;

    private String currency;

    public BigDecimal getTotal() {
        return total;
    }

    public Recipient setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public Recipient setCommission(BigDecimal commission) {
        this.commission = commission;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public Recipient setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
}
