package accounts.factories;

import accounts.BankAccount;
import accounts.SaveBankAccount;
import accounts.StudentBankAccount;
import accounts.generators.BankAccountNumberGenerator;
import persons.customers.Customer;

public class BankAccountFactory {

    private final BankAccountNumberGenerator bankAccountNumberGenerator = new BankAccountNumberGenerator();

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
