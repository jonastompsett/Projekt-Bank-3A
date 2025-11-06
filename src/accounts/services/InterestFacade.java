package accounts.services;

import accounts.SaveBankAccount;
import accounts.factories.BankAccountFactory;
import java.time.LocalDateTime;

public class InterestFacade {

    private final InterestCalculator calculator = new InterestCalculator();

    private LocalDateTime lastInterestTime = LocalDateTime.now().minusMinutes(5);

    public void processInterest() {
        LocalDateTime now = LocalDateTime.now();

        if (lastInterestTime.plusMinutes(5).isAfter(now)) {
            return;
        }

        System.out.println("uroceni sporicich uctu...");

        for (SaveBankAccount acc : BankAccountFactory.savingAccounts) {
            double interest = calculator.calculateInterest(acc);

            acc.setBalance(acc.getBalance() + interest);

            System.out.println("ucet " + acc.getBankAccountNumber() +
                    " ziskal urok: " + interest +
                    " novy zustatek: " + acc.getBalance());
        }
        lastInterestTime = now;
    }
}
