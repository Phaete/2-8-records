package com.phaete;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    @Test
    void openAccount_shouldReturn1_onNewBankService() {
        BankService bankService = new BankService();
        assertEquals("1", bankService.openAccount(new Client[]{new Client("John", "Doe", 1)}));
    }

    @Test
    void openAccount_shouldReturn3_with2PriorEntries() {
        BankService bankService = new BankService();
        bankService.openAccount(new Client[]{new Client("Peter", "Parker", 1055)});
        bankService.openAccount(new Client[]{new Client("Bruce", "Banner", 493)});
        assertEquals("3", bankService.openAccount(new Client[]{new Client("Tony", "Stark", 4723)}));
    }

    @Test
    void transfer_fromAccountWith1000BalanceShouldHaveNothingLeft_onTransferAll() {

        BankService bankServiceTransfer = new BankService();
        String fromAccountNumber = bankServiceTransfer.openAccount(new Client[]{new Client("John", "Doe", 1)});
        bankServiceTransfer.getAccounts().get(fromAccountNumber).deposit(new BigDecimal(1000));

        String toAccountNumber = bankServiceTransfer.openAccount(new Client[]{new Client("Jane", "Doe", 2)});

        bankServiceTransfer.transfer(fromAccountNumber, toAccountNumber, new BigDecimal(1000));

        assertEquals(new BigDecimal(1000), bankServiceTransfer.accounts.get(toAccountNumber).getAccountBalance());
    }

    @Test
    void split_returns1Accounts_onSplittingAnAccountWith1Client() {
        BankService bankService = new BankService();
        String accountNumber = bankService.openAccount(new Client[]{new Client("Peter", "Parker", 1055)});

        List<String> newAccounts = bankService.split(accountNumber);
        assertEquals(1, newAccounts.size());
    }

    @Test
    void split_returnsMultipleAccounts_onSplittingAnAccountWithMultipleClient() {
        BankService bankService = new BankService();
        String accountNumber = bankService.openAccount(new Client[]{
                new Client("Peter", "Parker", 1055),
                new Client("Tony", "Stark", 4755),
                new Client("John", "Doe", 1),
                new Client("Jane", "Doe", 2)
        });

        List<String> newAccounts = bankService.split(accountNumber);
        assertEquals(4, newAccounts.size());
    }


}