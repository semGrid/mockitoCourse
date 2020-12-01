package com.griddynamics.conversion.entities;

import com.google.common.base.Objects;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CurrencyId implements Serializable {

    @Column(name = "from_currency")
    @ApiModelProperty(notes = "From currency code", example = "EUR")
    private String from;

    @Column(name = "to_currency")
    @ApiModelProperty(notes = "To currency code", example = "USD")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyId that = (CurrencyId) o;
        return Objects.equal(from, that.from) &&
                Objects.equal(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(from, to);
    }
}
