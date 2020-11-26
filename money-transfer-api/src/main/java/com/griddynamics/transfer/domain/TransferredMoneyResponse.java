package com.griddynamics.transfer.domain;

public class TransferredMoneyResponse {

    private Recipient recipient;

    private TransactionStatus status;

    public Recipient getRecipient() {
        return recipient;
    }

    public TransferredMoneyResponse setRecipient(Recipient recipient) {
        this.recipient = recipient;
        return this;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public TransferredMoneyResponse setStatus(TransactionStatus status) {
        this.status = status;
        return this;
    }
}
