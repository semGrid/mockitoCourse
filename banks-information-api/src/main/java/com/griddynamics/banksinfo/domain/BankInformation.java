package com.griddynamics.banksinfo.domain;

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
    private String code;

    @Column(name = "currency")
    private String currency;

    @Column(name = "name")
    private String name;

    @Column(name = "commission_percentage")
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
