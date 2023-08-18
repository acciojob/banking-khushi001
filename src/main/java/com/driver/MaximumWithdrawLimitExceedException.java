package com.driver;

public class MaximumWithdrawLimitExceedException extends Exception {

    public MaximumWithdrawLimitExceedException() {
        System.out.println("Maximum Withdraw Limit Exceed");
    }
}
