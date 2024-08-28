package com.phaete;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private String accountNumber;
    private BigDecimal accountBalance;
    private Client[] clients;


    public Account(String accountNumber, BigDecimal accountBalance, Client[] clients) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.clients = clients;
    }

    public void deposit(BigDecimal amount) {
        accountBalance = accountBalance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        accountBalance = accountBalance.subtract(amount);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClient(Client[] clients) {
        this.clients = clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber) && Objects.equals(accountBalance, account.accountBalance) && Objects.equals(clients, account.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountBalance, clients);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountBalance=" + accountBalance +
                ", clients=" + clients +
                '}';
    }
}
