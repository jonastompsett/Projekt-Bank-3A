package accounts.services;

import accounts.SaveBankAccount;

public class InterestService {

    public void calculateAndApplyInterest(SaveBankAccount account) {
        double balance = account.getBalance();
        float rate = account.getInterestRate();

        if (balance <= 0 || rate <= 0) {
            return;
        }

        double interest = balance * (rate / 100);
        account.setBalance(balance + interest);
    }
}

