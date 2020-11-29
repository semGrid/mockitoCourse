package com.griddynamics.conversion.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@ApiModel(value = "Currency Conversion", description = "Currency conversion request")
public class CurrencyConversionRequest {

    @NotNull(message = "fromCurrency is required")
    @Size(max = 4, message = "Max allowed size is 4 chars")
    @ApiModelProperty(notes = "From currency", example = "EUR")
    private String fromCurrency;

    @NotNull(message = "toCurrency is required")
    @Size(max = 4, message = "Max allowed size is 4 chars")
    @ApiModelProperty(notes = "To currency", example = "USD")
    private String toCurrency;

    @NotNull(message = "amount is required")
    @ApiModelProperty(notes = "Amount", example = "200")
    private BigDecimal amount;

    public String getFromCurrency() {
        return fromCurrency;
    }

    public CurrencyConversionRequest setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
        return this;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public CurrencyConversionRequest setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public CurrencyConversionRequest setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }
}
