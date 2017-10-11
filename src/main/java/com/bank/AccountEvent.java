package com.bank;

import java.text.DecimalFormat;
import java.util.Date;

public class AccountEvent {

    private Account account;
    private Date when;
    private EventType eventType;
    private Double amount;

    public AccountEvent(Account account, Date when, EventType eventType, Double amount) {
        this.account = account;
        this.when = when;
        this.eventType = eventType;
        this.amount = amount;
    }

    public AccountEvent() {}

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public String getAmount() {
        return new DecimalFormat("##.##").format(amount);
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}