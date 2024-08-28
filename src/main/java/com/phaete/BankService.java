package com.phaete;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    Map<String, Account> accounts = new HashMap<>();

    public String openAccount(Client[] clients) {
        Account account = new Account(
                String.valueOf(accounts.size()+1),
                BigDecimal.ZERO,
                clients);
        accounts.put(account.getAccountNumber(), account);
        return account.getAccountNumber();
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        accounts.get(fromAccountNumber).withdraw(amount);
        accounts.get(toAccountNumber).deposit(amount);
    }

    public List<String> split(String accountNumber) {
        BigDecimal amount = accounts.get(accountNumber).getAccountBalance().divide(BigDecimal.valueOf(accounts.get(accountNumber).getClients().length), RoundingMode.HALF_EVEN);
        BigDecimal error = accounts.get(accountNumber).getAccountBalance().subtract(amount.multiply(BigDecimal.valueOf(2)));

        List<String> newAccounts = new ArrayList<>();
        for (Client client : accounts.get(accountNumber).getClients()) {
            String newAccountNumber = openAccount(new Client[]{client});
            newAccounts.add(newAccountNumber);
            accounts.get(newAccountNumber).deposit(amount);
        }
        // the last one gets the rest
        accounts.get(newAccounts.getLast()).deposit(error);

        accounts.remove(accountNumber);

        return newAccounts;
    }



    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Map<String, Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "BankService{" +
                "accounts=" + accounts +
                '}';
    }
}
