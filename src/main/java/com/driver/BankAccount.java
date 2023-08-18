package com.driver;


public class BankAccount {
    public BankAccount() {
    }
    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }


    public void deposit(double amount) {
        balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance-amount<minBalance){
            throw new Exception("Insufficient Balance");
        }else {
            balance-=amount;
        }
    }
    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

        if(sum < 0 || sum > 9 * digits){
            throw new Exception("Account Number can not be generated");
        }
        int[] accountDigits = new int[digits];
        for (int i = 0; i < digits - 1; i++) {
            int maxDigitValue = Math.min(sum, 9);
            int randomDigit = (int) (Math.random() * (maxDigitValue + 1));
            accountDigits[i] = randomDigit;
            sum -= randomDigit;
        }

        accountDigits[digits - 1] = sum;

        StringBuilder accountNumber = new StringBuilder();
        for (int digit : accountDigits) {
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }
}