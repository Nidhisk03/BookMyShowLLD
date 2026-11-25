import entities.*;
import enums.SeatStatus;
import enums.SeatType;
import payment.CreditCardPayment;
import payment.WeekdayPrice;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    MovieBookingService service = MovieBookingService.getInstance();

    service.createUser("User1","Nidhi","nskandalkar03@gmail.com");


    service.addCity("City1","Pune");
    service.addCity("City2","Mumbai");
    Movie movie1 = service.addMovie("Movie1","Ramayan",180);
    Movie movie2 = service.addMovie("Movie2","Brahamastra",180);

    Screen screen1 = new Screen("Screen1","A");
    Screen screen2 = new Screen("Screen2","B");
    Screen screen3 = new Screen("Screen3","C");
    Screen screen4 = new Screen("Screen4","D");

    for (int i = 1; i <= 10; i++) {
        screen1.addSeat(new Seat("A" + i, 1, i, i <= 5 ? SeatType.REGULAR : SeatType.PREMIUM));
        screen1.addSeat(new Seat("B" + i, 2, i, i <= 5 ? SeatType.REGULAR : SeatType.PREMIUM));
    }

   Theatre theatre1 =  service.addTheatre("Theatre1", "RajKala","City1",List.of(screen1));
   Theatre theatre2 =  service.addTheatre("Theatre2", "Millennium","City1",List.of(screen2));
   Theatre theatre3 =  service.addTheatre("Theatre3", "Millennium","City2",List.of(screen3));

    Show show1 = service.addShow("Show1",movie1,theatre1,screen1,LocalDateTime.now().plusHours(2),new WeekdayPrice());
    Show show2 = service.addShow("Show2",movie1,theatre2,screen2,LocalDateTime.now().plusHours(2),new WeekdayPrice());
    Show show3 = service.addShow("Show3",movie1,theatre3,screen3,LocalDateTime.now().plusHours(2),new WeekdayPrice());

    List<Show> show = service.findShow("Ramayan", "Pune");

//    for (int i = 0;i<show.size();i++){
//        System.out.println(show.get(i).getMovie().getName()+" "+ show.get(i).getTheatre().getName()+" "+show.get(i).getTheatre().getCity().getName());
//    }

    if(show.isEmpty()){
        System.out.println("No show available");
    }

    Show selectedShow = show.get(0);
    List<Seat> availableSeats = selectedShow.getScreen().getSeats().stream()
            .filter(seat -> seat.getSeatStatus()==SeatStatus.AVAILABLE).toList();

    System.out.printf("Available seats for '%s' at %s: %s%n",
            selectedShow.getMovie().getName(),
            selectedShow.getStartTime(),
            availableSeats.stream().map(Seat::getId).collect(Collectors.toList()));

    List<Seat> desiredSeats = List.of(availableSeats.get(1),availableSeats.get(3),availableSeats.get(16));
    System.out.println("Selected seat: "+ desiredSeats.stream().map(Seat::getId).toList());

    Booking booking = service.bookTickets("User1", show1.getId(), desiredSeats,new CreditCardPayment(5446700,236));

    if (booking!= null) {

        System.out.println("\n--- Booking Successful! ---");
        System.out.println("Booking ID: " + booking.getId());
        System.out.println("User: " + booking.getUser().getName());
        System.out.println("Movie: " + booking.getShow().getMovie().getName());
        System.out.println("Seats: " + booking.getSeats().stream().map(Seat::getId).toList());
        System.out.println("Total Amount: $" + booking.getTotalAmount());
        System.out.println("Payment Status: " + booking.getPayment().getStatus());
    } else {
        System.out.println("Booking failed.");
    }




}
