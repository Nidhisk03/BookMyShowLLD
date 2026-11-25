import entities.*;
import payment.PaymentStrategy;
import payment.PricingStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieBookingService {

    static private  final  MovieBookingService service = new MovieBookingService();

    HashMap<String, User> users;
    HashMap<String , City> cities;
    HashMap<String , Theatre> theatres;
    HashMap<String , Movie> movies;
    HashMap<String , Show> shows;

    private MovieBookingService(){
        users = new HashMap<>();
        cities = new HashMap<>();
        theatres = new HashMap<>();
        movies = new HashMap<>();
        shows = new HashMap<>();
    }


    BookingManager bookingManager = BookingManager.getInstance();


    public void createUser(String id, String name , String email){
        User user = new User(id,name,email);
        users.put(id,user);
    }
    public User getUser(String id){
        return users.get(id);
    }
    public City getCity(String id){
        return cities.get(id);
    }
    public void addCity(String id, String name){
        City city = new City(id,name);
        cities.put(id,city);
    }

    public Theatre addTheatre(String theatreId, String name, String cityId, List<Screen> screens){
        City city = cities.get(cityId);
        Theatre theatre = new Theatre(theatreId,name,city,screens);
        theatres.put(theatre.getId(),theatre);
        return theatre;
    }
    public Movie addMovie(String id, String title, int duration){
       Movie movie = new Movie(id, title,duration);
       movies.put(movie.getId(), movie);
       return movie;
    }

    public Show addShow(String id, Movie movie, Theatre theatre, Screen screen, LocalDateTime startTime, PricingStrategy pricingStrategy){
        Show show= new Show(id,movie,theatre,screen,startTime,pricingStrategy);
        shows.put(show.getId(),show);
        return show;
    }

    List<Show> findShow(String movieTitle, String cityName){
        ArrayList<Show> result = new ArrayList<>();
        shows.values().stream().filter(show -> show.getMovie().getName().equalsIgnoreCase(movieTitle))
                .filter(show -> {
                    Theatre theatre = findTheatreForShow(show);
                   return theatre!=null &&  theatre.getCity().getName().equals(cityName);
                }).forEach(result::add);

        return result;
    }

    Theatre findTheatreForShow(Show show){

      return theatres.values().stream().filter
              (theatre -> theatre.getScreenList().contains(show.getScreen()))
              .findFirst().orElse(null);

    }



    public Booking bookTickets(String userId, String showId, List<Seat> desiredSeats , PaymentStrategy paymentStrategy){
        return bookingManager.createBooking(users.get(userId),shows.get(showId),desiredSeats,paymentStrategy);
    }










    static public MovieBookingService getInstance(){
        return service;
    }

}
