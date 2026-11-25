import entities.*;
import enums.PaymentStatus;
import payment.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class BookingManager {

   static final BookingManager manager = new BookingManager();

    private BookingManager(){

    }
    public static BookingManager getInstance() {
        return manager;
    }


    public Booking createBooking(User user, Show show, List<Seat> desiredSeats, PaymentStrategy paymentStrategy) {

        int totalCost = show.getPricingStrategy().calculatePrice(desiredSeats);
        Payment payment = paymentStrategy.payment(totalCost);
        if(payment.getStatus().equals(PaymentStatus.SUCCESS)){
            Booking booking =  new Booking(user,show,desiredSeats,totalCost,payment);
            booking.conformBooking(desiredSeats);
            return booking;
        }else{
            System.out.println("Payment Failed");
            return null;
        }

    }
}
