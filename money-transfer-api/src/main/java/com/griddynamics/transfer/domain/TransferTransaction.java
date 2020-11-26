package com.griddynamics.transfer.domain;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfer_transactions")
public class TransferTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(notes = "The database generated product ID")
    private int id;

    @Column(name = "transaction_date")
    @CreationTimestamp
    @ApiModelProperty(notes = "The database generated transaction date and time")
    private LocalDateTime transactionDate;

    @Column(name = "bank_of_recipient")
    @ApiModelProperty(notes = "Code of recipient bank")
    private String bankOfRecipient;

    @Column(name = "transaction_currency")
    @ApiModelProperty(notes = "Currency of sending money")
    private String transactionCurrency;

    @Column(name = "transaction_amount")
    @ApiModelProperty(notes = "Amount sending money")
    private BigDecimal transactionAmount;

    public int getId() {
        return id;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getBankOfRecipient() {
        return bankOfRecipient;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }
}
