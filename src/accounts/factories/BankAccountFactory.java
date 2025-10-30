package accounts.factories;

import accounts.BankAccount;
import accounts.SaveBankAccount;
import accounts.StudentBankAccount;
import accounts.generators.BankAccountNumberGenerator;
import com.google.inject.Inject;
import persons.customers.Customer;

public class BankAccountFactory {

    @Inject
    private BankAccountNumberGenerator bankAccountNumberGenerator;

    public BankAccount createBankAccount(String uuid, Customer customer) {
        return new BankAccount(
                uuid,
                bankAccountNumberGenerator.generateRandomAccountNumber(),
                customer
        );
    }

    public SaveBankAccount createSaveAccount(String uuid, Customer customer, float interestRate) {
        return new SaveBankAccount(
                uuid,
                bankAccountNumberGenerator.generateRandomAccountNumber(),
                customer,
                interestRate
        );
    }

    public StudentBankAccount createStudentAccount(String uuid, Customer customer, String schoolName) {
        return new StudentBankAccount(
                uuid,
                bankAccountNumberGenerator.generateRandomAccountNumber(),
                customer,
                schoolName
        );
    }

}
