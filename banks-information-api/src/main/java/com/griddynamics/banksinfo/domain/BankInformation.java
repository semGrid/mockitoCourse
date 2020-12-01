package com.griddynamics.banksinfo.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "banks")
public class BankInformation {

    @Id
    @Column(name = "code")
    @ApiModelProperty(notes = "Bank code", example = "CB")
    private String code;

    @Column(name = "currency")
    @ApiModelProperty(notes = "Bank currency code", example = "USD")
    private String currency;

    @Column(name = "name")
    @ApiModelProperty(notes = "Bank name", example = "City Bank")
    private String name;

    @Column(name = "commission_percentage")
    @ApiModelProperty(notes = "Bank commission percentage", example = "0.0")
    private BigDecimal commissionPercentage;

    public String getCode() {
        return code;
    }

    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCommissionPercentage() {
        return commissionPercentage;
    }
}
