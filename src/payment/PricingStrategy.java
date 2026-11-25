package payment;

import entities.Seat;

import java.util.List;

public interface PricingStrategy {

  public   int calculatePrice(List<Seat> seats);
}
