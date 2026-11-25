package payment;

import entities.Seat;

import java.util.List;

public class WeekendPrice implements PricingStrategy{
    @Override
    public int calculatePrice(List<Seat> seats) {

        int total = 0;
        for(int i = 0;i<seats.size();i++){
            total = total+ seats.get(i).getSeatType().getPrice();
        }
        return (int)(total*0.5);
    }
}
