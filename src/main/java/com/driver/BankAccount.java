package com.driver;

public class BankAccount {

    private String name;
    public double balance;
    public double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;

    }

    public String generateAccountNumber(int digits, int sum) throws AccountNumberGenerationException{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if (sum < 0 || sum > digits * 9) {
            throw new AccountNumberGenerationException();
        }

        StringBuilder accountNumber = new StringBuilder();
        int remainingSum = sum;

        for (int i = 0; i < digits - 1; i++) {
            int maxDigitValue = Math.min(remainingSum, 9);
            int randomDigit = (int) (Math.random() * (maxDigitValue + 1));
            accountNumber.append(randomDigit);
            remainingSum -= randomDigit;
        }

        accountNumber.append(remainingSum);
        return accountNumber.toString();

    }

    public void deposit(double amount) {
        //add amount to balance
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if (balance - amount < minBalance) {
            throw new InsufficientBalanceException();
        }

        balance -= amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getMinBalance() {
        return balance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}
