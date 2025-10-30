
import accounts.services.InterestFacade;

import java.util.Timer;
import java.util.TimerTask;

public class InterestCron {

    private final InterestFacade facade;

    public InterestCron(InterestFacade facade) {
        this.facade = facade;
    }

    public void start() {
        Timer timer = new Timer(true);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                facade.processInterest();
            }
        }, 0, 60 * 1000); // každou minutu
    }
}

