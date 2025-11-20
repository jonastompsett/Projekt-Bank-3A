package accounts.services;

import accounts.BaseBankAccount;
import com.google.inject.Inject;
import logger.ConsoleLogger;
import logger.Logger;
import transactions.Transaction;
import transactions.TransactionFactory;
import transactions.TransactionManager;

public class BankAccountService {

    private final Logger logger = new ConsoleLogger();

    @Inject
    private TransactionFactory transactionFactory;

    @Inject
    private TransactionManager transactionManager;


    public void deposit(BaseBankAccount account, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }

        logger.log(account.getUuid() + ": + " + amount);


        if (amount > 10000) {
            System.err.println("Amount to be deposited is greater than 10000.");
        }

        // TODO AML legislativu (Anti Money Laundering – opatření proti praní špinavých peněz)

        double newBalance = account.getBalance() + amount;
        account.setBalance(newBalance);

        Transaction t = transactionFactory.createDeposit(
                account.getBankAccountNumber(),
                amount
        );
        transactionManager.addTransaction(account.getBankAccountNumber(), t);
    }

    public void withdraw(BaseBankAccount account, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (account.getBalance() < amount) {
            throw new IllegalStateException("Insufficient funds.");
        }

        logger.log(account.getUuid() + ": - " + amount);

        double newBalance = account.getBalance() - amount;
        account.setBalance(newBalance);
        Transaction t = transactionFactory.createWithdraw(
                account.getBankAccountNumber(),
                amount
        );
        transactionManager.addTransaction(account.getBankAccountNumber(), t);

    }
}
