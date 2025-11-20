package transactions;

import java.time.LocalDateTime;

public class TransactionFactory {

    public Transaction createDeposit(String account, double amount) {
        return new Transaction(LocalDateTime.now(), null, account, TransactionType.DEPOSIT, amount);
    }

    public Transaction createWithdraw(String account, double amount) {
        return new Transaction(LocalDateTime.now(), account, null, TransactionType.WITHDRAW, amount);
    }

    public Transaction createTransfer(String sender, String receiver, double amount) {
        return new Transaction(LocalDateTime.now(), sender, receiver, TransactionType.TRANSFER, amount);
    }
}
