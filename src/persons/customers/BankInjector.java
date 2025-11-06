package persons.customers;

import accounts.factories.BankAccountFactory;
import accounts.services.BankAccountService;
import accounts.services.InterestFacade;
import com.google.inject.AbstractModule;
import persons.customers.factories.CustomerFactory;

public class BankInjector extends AbstractModule {
    @Override
    protected void configure() {
        bind(BankAccountFactory.class);
        bind(BankAccountService.class);
        bind(CustomerFactory.class);

        bind(InterestFacade.class);
    }
}
