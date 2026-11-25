package entities;

import enums.SeatStatus;

import java.util.List;

public class Booking {
    private final String id;
    private final User user;
    private final Show show;
    private final List<Seat> seats;
    private final double totalAmount;
    private final Payment payment;
int total = 1;
    public Booking(User user, Show show, List<Seat> seats, double totalAmount, Payment payment) {
        this.id = "Booking"+total++;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.totalAmount = totalAmount;
        this.payment = payment;
    }

    public void conformBooking(List<Seat> seats){
        for(int i = 0;i<seats.size();i++){
            seats.get(i).setSeatStatus(SeatStatus.BOOKED);
        }
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Payment getPayment() {
        return payment;
    }
}
