package com.phaete;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Species tiger = new Species("Tiger", 500);
        Animal tigga = new Animal(1, "Tigga", tiger, 5, new Owner("John Doe", 45, "1 Main Street"));

        Species bear = new Species("Bear", 1000);
        Animal poo = new Animal(2, "Poo", bear, 4, new Owner("Jane Doe", 55, "2 Main Street"));

        Species dog = new Species("Dog", 300);
        Animal snuffles = new Animal(3, "Snuffles", dog, 3, new Owner("Sirius Black", 50, "3 Main Street"));
        Animal pluto = new Animal(4, "Pluto", dog, 3, new Owner("Pluto", 50, "500 South Buena Vista Street"));
        Animal brian = new Animal(5, "Brian Griffin", dog, 3, new Owner("Peter Griffin", 40, "31 Spooner Street"));

        // compare the animals, all should not be equal
        System.out.println(tigga.equals(poo));
        System.out.println(tigga.equals(snuffles));
        System.out.println(tigga.equals(pluto));

        // use toString()
        System.out.println(tigga);
        System.out.println(poo);
        System.out.println(snuffles);
        System.out.println(pluto);

        Zoo zoo = new Zoo(List.of(tigga, poo, snuffles, pluto, brian));

        BankService bankService = new BankService();
        Client john = new Client("John", "Doe", 1);
        Client jane = new Client("Jane", "Doe", 2);
        bankService.openAccount(new Client[] {john});
        bankService.accounts.get("1").deposit(new BigDecimal(1000));
        System.out.println(bankService.accounts.get("1").getAccountBalance());

        bankService.openAccount(new Client[] {john, jane});
        bankService.accounts.get("2").deposit(new BigDecimal(1000));
        System.out.println(bankService.split("2"));
        System.out.println(bankService.accounts);
    }
}