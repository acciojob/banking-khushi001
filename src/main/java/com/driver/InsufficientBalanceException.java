package com.driver;

public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException() {
        System.out.println("Insufficient Balance");
    }
}
