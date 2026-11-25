package entities;

import payment.PricingStrategy;

import java.time.LocalDateTime;

public class Show {
    String id;
    Movie movie;
    Theatre theatre;
    Screen screen;
    LocalDateTime startTime;
    PricingStrategy pricingStrategy;

    public Show(String id, Movie movie, Theatre theatre, Screen screen, LocalDateTime startTime, PricingStrategy pricingStrategy) {
        this.id = id;
        this.movie = movie;
        this.theatre = theatre;
        this.screen = screen;
        this.startTime = startTime;
        this.pricingStrategy = pricingStrategy;
    }

    public String getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }
}
