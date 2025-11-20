package transactions;

import java.util.Timer;
import java.util.TimerTask;

public class TransactionExportCron {

    private final TransactionExportFacade facade;

    public TransactionExportCron(TransactionExportFacade facade) {
        this.facade = facade;
    }

    public void start() {
        Timer timer = new Timer(true);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                facade.exportDaily();
            }
        }, 0, 24L * 60 * 60 * 1000);
    }
}
