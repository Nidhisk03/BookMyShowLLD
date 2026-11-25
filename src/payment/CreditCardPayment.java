package payment;

import entities.Payment;
import enums.PaymentStatus;

import java.util.UUID;

public class CreditCardPayment implements PaymentStrategy{
    int cardNumber;
    int cvv;

    public CreditCardPayment(int cardNumber, int cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public Payment payment(int amount) {

        System.out.println("Processing credit card payment of "+ amount);
        boolean paymentSuccess = Math.random()>=0.05;
        return new Payment(amount,paymentSuccess? PaymentStatus.SUCCESS:PaymentStatus.FAILURE,  UUID.randomUUID().toString());
    }
}
