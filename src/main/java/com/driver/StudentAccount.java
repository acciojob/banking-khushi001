package com.driver;

public class StudentAccount extends BankAccount{

    String  institutionName;

    public StudentAccount(String name, double balance, String  institutionName) {
        //minimum balance is 0 by default
        super(name, balance, 0); // Minimum balance requirement for student account is 0
        this.institutionName = institutionName;
    }

}
