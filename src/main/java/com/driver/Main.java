package com.driver;

public class Main {
    public static void main(String[] args) {
        try {
            // Creating instances of different account types
            SavingsAccount savingsAccount = new SavingsAccount("John Doe", 10000, 5000, 5.0);
            CurrentAccount currentAccount = new CurrentAccount("Alice Smith", 7000, "TRADE123");
            StudentAccount studentAccount = new StudentAccount("Eva Johnson", 0, "University XYZ");

            // Depositing and withdrawing from accounts
            savingsAccount.deposit(2000);
            System.out.println(savingsAccount.getSimpleInterest(2));

            // Display account information or perform other actions as needed
            // ...

        } catch (Exception e) {
            // Handle exceptions here
            e.printStackTrace();
        }
    }
}