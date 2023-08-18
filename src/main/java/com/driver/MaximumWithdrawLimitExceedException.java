package com.driver;

public class MaximumWithdrawLimitExceedException extends Exception {

    public MaximumWithdrawLimitExceedException() {
        super("Maximum Withdraw Limit Exceed");
    }
}
