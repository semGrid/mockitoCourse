package com.griddynamics.conversion.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CurrencyId implements Serializable {

    @Column(name = "from_currency")
    private String from;

    @Column(name = "to_currency")
    private String to;

    public CurrencyId() {
    }

    public CurrencyId(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public CurrencyId setFrom(String from) {
        this.from = from;
        return this;
    }

    public CurrencyId setTo(String to) {
        this.to = to;
        return this;
    }
}
