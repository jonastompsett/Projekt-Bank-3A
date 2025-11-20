package transactions;

import java.time.LocalDateTime;

public class Transaction {

    private final LocalDateTime date;
    private final String sender;
    private final String receiver;
    private final TransactionType type;
    private final double amount;

    public Transaction(LocalDateTime date, String sender, String receiver, TransactionType type, double amount) {
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
        this.type = type;
        this.amount = amount;
    }

    public LocalDateTime getDate() { return date; }
    public String getSender() { return sender; }
    public String getReceiver() { return receiver; }
    public TransactionType getType() { return type; }
    public double getAmount() { return amount; }
}
