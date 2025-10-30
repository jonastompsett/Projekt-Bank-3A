package cards.services;

import accounts.BaseBankAccount;
import cards.PaymentCard;
import cards.factories.PaymentCardFactory;
import com.google.inject.Inject;

import java.util.HashMap;
import java.util.Map;


public class PaymentCardService {
    private final Map<String, PaymentCard> paymentCards = new HashMap<>();;

    @Inject
    private PaymentCardFactory paymentCardFactory;

    public PaymentCard create(BaseBankAccount bankAccount) {
        PaymentCard paymentCard = this.paymentCardFactory.create(bankAccount);
        this.paymentCards.put(paymentCard.getCardNumber(), paymentCard);

        return paymentCard;
    }

    public PaymentCard getPaymentCard(String cardNumber) {
        return this.paymentCards.get(cardNumber);
    }
}
