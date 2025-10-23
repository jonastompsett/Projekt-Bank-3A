import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        System.out.println("");
        Injector injector = Guice.createInjector(new persons.customers.BankInjector());
        App app = injector.getInstance(App.class);

        // now all your @Inject fields are initialized!
        app.run();
    }

}