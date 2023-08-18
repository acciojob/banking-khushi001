package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{

    private String tradeLicenseId; //consists of Uppercase English characters only
    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public CurrentAccount(String name, double balance,String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
        if(balance<5000){
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        char[] chars = tradeLicenseId.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                rearrangeLicenseIdChars(chars, i);
                return;
            }
        }
        throw new Exception("Valid License can not be generated");
    }

    private void rearrangeLicenseIdChars(char[] chars, int index) throws Exception {
        if (index + 1 < chars.length) {
            char temp = chars[index];
            chars[index] = chars[index + 1];
            chars[index + 1] = temp;
            tradeLicenseId = new String(chars);
        } else {
            throw new Exception("Valid License can not be generated");
        }
    }

}