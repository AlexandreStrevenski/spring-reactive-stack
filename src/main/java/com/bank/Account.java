package com.bank;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@ToString
public class Account {

    @Id
    private String id;
    private String customer;
    private Double balance;

    public Account(String id, String customer, Double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account - id: +" + getId() + " customer: "+getCustomer()+", balance: "+getBalance();
    }

}