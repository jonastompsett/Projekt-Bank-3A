package accounts.services;

import accounts.SaveBankAccount;

public class InterestCalculator {

    public double calculateInterest(SaveBankAccount account) {
        double balance = account.getBalance();
        float rate = account.getInterestRate();
        return balance * rate;
    }
}

