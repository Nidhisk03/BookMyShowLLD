package payment;

import entities.Payment;

public interface PaymentStrategy {

   public   Payment payment(int amount);
}
