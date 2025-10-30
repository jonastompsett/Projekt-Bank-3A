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
    }

    public SaveBankAccount(String uuid, String bankAccountNumber, Customer customer) {
        this(uuid, bankAccountNumber, customer, 0);
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
