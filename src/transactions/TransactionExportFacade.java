package transactions;

import com.google.inject.Inject;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;

    public class TransactionExportFacade {

        private final TransactionManager manager;

        @Inject
        public TransactionExportFacade(TransactionManager manager) {
            this.manager = manager;
        }

        public void exportDaily() {
            LocalDate today = LocalDate.now();

            try (FileWriter fw = new FileWriter("transactions-" + today + ".txt")) {
                List<Transaction> list = manager.getAll();

                for (Transaction t : list) {
                    if (t.getDate().toLocalDate().equals(today)) {
                        fw.write(
                                t.getDate() + " | " +
                                        "sender=" + t.getSender() + " | " +
                                        "receiver=" + t.getReceiver() + " | " +
                                        t.getType() + " | " +
                                        t.getAmount() + "\n"
                        );
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
