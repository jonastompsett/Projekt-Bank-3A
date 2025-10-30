package accounts.services;

import accounts.SaveBankAccount;
import accounts.factories.BankAccountFactory;
import java.time.LocalDateTime;

public class InterestFacade {

    private final InterestCalculator calculator = new InterestCalculator();

    // Pamatujeme si kdy jsme naposledy úročili
    private LocalDateTime lastInterestTime = LocalDateTime.now().minusMinutes(5);

    public void processInterest() {
        LocalDateTime now = LocalDateTime.now();

        // Zkontrolujeme jestli už uběhlo 5 minut
        if (lastInterestTime.plusMinutes(5).isAfter(now)) {
            return; // ještě není čas úročit
        }

        System.out.println("✅ Úročení spořících účtů...");

        for (SaveBankAccount acc : BankAccountFactory.savingAccounts) {
            double interest = calculator.calculateInterest(acc);

            // Přičteme úrok k účtu
            acc.setBalance(acc.getBalance() + interest);

            System.out.println("ucet " + acc.getBankAccountNumber() +
                    " ziskal urok: " + interest +
                    " | novy zustatek: " + acc.getBalance());
        }

        // nastavíme čas dalšího úročení
        lastInterestTime = now;
    }
}
