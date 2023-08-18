package com.driver;

public class AccountNumberGenerationException extends Exception {

    public AccountNumberGenerationException() {
        super("Account Number can not be generated");
    }
}
