package cards.factories;

import accounts.BaseBankAccount;
import cards.generators.PaymentCardCvvGenerator;
import cards.generators.PaymentCardNumberGenerator;
import cards.generators.PaymentCardPinGenerator;
import cards.*;
import com.google.inject.Inject;

import java.util.UUID;

public class PaymentCardFactory {

    @Inject
    private PaymentCardNumberGenerator paymentCardNumberGenerator;

    @Inject
    private PaymentCardCvvGenerator paymentCardCvvGenerator;

    @Inject
    private PaymentCardPinGenerator paymentCardPinGenerator;

    @Inject
    private PaymentCardExpirationCalculator paymentCardExpirationCalculator;

    public PaymentCard create(BaseBankAccount bankAccount) {

        String uuid = UUID.randomUUID().toString();
        String cardNUmber = this.paymentCardNumberGenerator.generateCardNumber();
        String cvv = this.paymentCardCvvGenerator.generateCvv();
        // !!!
        String pin = this.paymentCardPinGenerator.generatePin();
        String expireMonth = this.paymentCardExpirationCalculator.calculateMonthExpire();
        String expireYear = this.paymentCardExpirationCalculator.calculateYearExpire();

        return new PaymentCard(uuid, cardNUmber, cvv, pin, expireMonth, expireYear);
    }
}
