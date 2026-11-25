package entities;

import java.util.ArrayList;
import java.util.SplittableRandom;

public class Screen {
    String id;
    String name;
    ArrayList<Seat> seats;

    public Screen(String id, String name) {
        this.id = id;
        this.name = name;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat){
        seats.add(seat);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }
}
