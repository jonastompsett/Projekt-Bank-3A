package accounts;

import persons.customers.Customer;

import java.time.LocalDateTime;

public class SaveBankAccount extends BaseBankAccount {

    private final float interestRate;

    private LocalDateTime nextInterestTime;

    public SaveBankAccount(String uuid, String bankAccountNumber, Customer customer, float interestRate) {
        super(uuid, bankAccountNumber, customer, 0);

        this.interestRate = interestRate;
        this.nextInterestTime = LocalDateTime.now();

        this.nextInterestTime = LocalDateTime.now().plusMinutes(5);
    }

    public float getInterestRate() {
        return interestRate;
    }

    public LocalDateTime getNextInterestTime() {
        return nextInterestTime;
    }

    public void setNextInterestTime(LocalDateTime nextInterestTime) {
        this.nextInterestTime = nextInterestTime;
    }
}
