import accounts.BankAccount;
import accounts.BaseBankAccount;
import accounts.SaveBankAccount;
import accounts.factories.BankAccountFactory;
import accounts.generators.BankAccountNumberGenerator;
import accounts.services.BankAccountService;
import accounts.services.InterestFacade;
import cards.*;
import com.google.inject.Inject;
import logger.ConsoleLogger;
import logger.FileSystemLogger;
import logger.Logger;
import persons.customers.Customer;
import persons.customers.factories.CustomerFactory;


public class App {
    @Inject
    private FileSystemLogger fileSystemLogger;

    @Inject
    private CustomerFactory customerFactory;

    @Inject
    private BankAccountService bankAccountService;

    @Inject
    private BankAccountFactory bankAccountFactory;

    @Inject
    private InterestFacade interestFacade;


    public void run() {
        Customer customer = customerFactory.createCustomer("c-123", "Jonas", "Tompsett");
        fileSystemLogger.log(customer.getUuid() + ": " + customer.getFirstName() + " " + customer.getLastName());

        fileSystemLogger.log("=== TEST BANK ACCOUNT");
        BaseBankAccount account1 = testBankAccount(customer);

        fileSystemLogger.log(account1 instanceof BankAccount ? "Bank" : "Save");

        fileSystemLogger.log("=== TEST SAVE ACCOUNT");
        BaseBankAccount account2 = testSaveAccount(customer);
        fileSystemLogger.log(account2 instanceof  BankAccount ? "Bank" : "Save");

        if (account2 instanceof SaveBankAccount) {
            float interestRate = ((SaveBankAccount)account2).getInterestRate();
            fileSystemLogger.log("Interest Rate: " + interestRate);
        }

        InterestCron cron = new InterestCron(interestFacade);
        cron.start();

        System.out.println("cron running in background.");

    }

    private BaseBankAccount testSaveAccount(Customer customer) {
        BaseBankAccount account = bankAccountFactory.createSaveAccount(
                "u-123",
                customer,
                0.5f
        );

        try{
            fileSystemLogger.log(account.getUuid() + "(" + account.getBankAccountNumber() + "): " + account.getBalance());

            // account.addBalance(500);
            bankAccountService.deposit(account, 500);
            fileSystemLogger.log(account.getUuid() + ": " + account.getBalance());

            // account.subtractBalance(400);
            bankAccountService.withdraw(account, 500);
            fileSystemLogger.log(account.getUuid() + ": " + account.getBalance());

        } catch (Exception e) {
            fileSystemLogger.log("Error: " + e.getMessage());
        }

        return account;
    }

    private BaseBankAccount testBankAccount(Customer customer) {
        BaseBankAccount account = bankAccountFactory.createBankAccount(
                "u-123",
                customer
        );

        try {
            fileSystemLogger.log(account.getUuid() + " (" + account.getBankAccountNumber() + "): " + account.getBalance());

            // account.addBalance(500);
            bankAccountService.deposit(account, 500);
            fileSystemLogger.log(account.getUuid() + ": " + account.getBalance());

            bankAccountService.deposit(account, 400);
            fileSystemLogger.log(account.getUuid() + ": " + account.getBalance());

            // account.subtractBalance(300);
            bankAccountService.withdraw(account, 300);

        } catch (Exception e) {
            fileSystemLogger.log("Error: " + e.getMessage());
        }

        return account;
    }

}
