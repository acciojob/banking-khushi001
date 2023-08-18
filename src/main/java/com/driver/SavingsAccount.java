package com.driver;
import com.driver.MaximumWithdrawLimitExceedException;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0); // Minimum balance requirement for savings account is 0 by default
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;

    }
    public void withdraw(double amount) throws InsufficientBalanceException  {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if (amount > maxWithdrawalLimit) {
            try {
                throw new MaximumWithdrawLimitExceedException();
            } catch (MaximumWithdrawLimitExceedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            super.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            // Handle the InsufficientBalanceException here if needed
            throw e; // Rethrow the exception
        }

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double interest = balance * rate * years / 100;
        return balance + interest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double compoundInterest = balance * Math.pow(1 + rate / (times * 100), times * years);
        return compoundInterest;
    }

}
