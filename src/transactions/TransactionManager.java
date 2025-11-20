package transactions;

import java.util.*;

public class TransactionManager {

    private final Map<String, List<Transaction>> history = new HashMap<>();

    public void addTransaction(String account, Transaction t) {
        history.computeIfAbsent(account, a -> new ArrayList<>()).add(t);
    }

    public List<Transaction> getTransactions(String account) {
        return history.getOrDefault(account, Collections.emptyList());
    }

    public List<Transaction> getAll() {
        return history.values()
                .stream()
                .flatMap(List::stream)
                .toList();
    }
}
