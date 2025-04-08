package DesignBookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//Driver Method
public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    BookMyShow() {
        movieController = new MovieController();
        theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        bookMyShow.createBooking(City.Bangalore, "AVENGERS");
        bookMyShow.createBooking(City.Bangalore, "AVENGERS");
    }

    private void createBooking(City userCity, String movieName) {


        //1. search movie by my location
        List<Movie> movies = movieController.getMoviesByCity(userCity);

        //2. select the movie which you want to see. i want to see threeIdiots
        Movie interestedMovie=null;
        for (Movie movie : movies) {

            if ((movie.getMovieName()).equals(movieName)) {
                interestedMovie = movie;
                break;
            }
        }

        if (interestedMovie == null) {
            System.out.println("No movie is placed today for the requested movie: " + movieName);
            return;
        }

        //3. get all show of this movie in Bangalore location
        Map<Theatre, List<Show>> showsTheatreWise = theatreController.getAllShow(interestedMovie, userCity);

        //4. select the particular show user is interested in
        Map.Entry<Theatre, List<Show>> entry = showsTheatreWise.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        //5. select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeatId();
        if (!bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);
            //startPayment
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for (Seat screenSeat : interestedShow.getScreen().getSeats()) {
                if (screenSeat.getSeatNumber() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeat(myBookedSeats);
            booking.setShow(interestedShow);
        } else {
            //throw exception
            System.out.println("seat already booked, try again");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }


    private void initialize() {
        createMovie();
        createTheatre();
    }

    private void createTheatre() {
        Movie avengerMovie = movieController.getMovieByName("AVENGERS");
        Movie baahubali = movieController.getMovieByName("BAAHUBALI");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheaterId(1);
        inoxTheatre.setScreen(createScreen());
        inoxTheatre.setCity(City.Bangalore);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inoxTheatre.getScreen().get(0), avengerMovie, 8);
        Show inoxEveningShow = createShows(2, inoxTheatre.getScreen().get(0), baahubali, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShow(inoxShows);


        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheaterId(2);
        pvrTheatre.setScreen(createScreen());
        pvrTheatre.setCity(City.Delhi);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getScreen().get(0), avengerMovie, 13);
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreen().get(0), baahubali, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShow(pvrShows);

        theatreController.addTheatre(inoxTheatre, City.Bangalore);
        theatreController.addTheatre(pvrTheatre, City.Delhi);

    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {

        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setShowStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;
    }


    private List<Screen> createScreen() {
        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);

        return screens;

    }
    private List<Seat> createSeats() {

        List<Seat> seats = new ArrayList<>();

        // Define ranges for each seat category (you can easily adjust these values)
        createSeatsForCategory(seats, 0, 40, SeatCategory.SILVER);
        createSeatsForCategory(seats, 40, 70, SeatCategory.GOLD);
        createSeatsForCategory(seats, 70, 100, SeatCategory.PLATINUM);

        return seats;
    }

    // Helper method to reduce duplication
    private void createSeatsForCategory(List<Seat> seats, int seatStart, int seatEnd, SeatCategory category) {
        for (int i = seatStart; i < seatEnd; i++) {
            Seat seat = new Seat();
            seat.setSeatNumber(i);
            seat.setSeatCategory(category);
            seats.add(seat);
        }
    }



    private void createMovie() {
        //create 1 Movie

        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setMovieName("AVENGERS");
        avengers.setMovieDuration(128);

        //create Movies2
        Movie baahubali = new Movie();
        baahubali.setMovieId(2);
        baahubali.setMovieName("BAAHUBALI");
        baahubali.setMovieDuration(180);


        //add movies against the cities
        movieController.add(avengers, City.Bangalore);
        movieController.add(avengers, City.Delhi);
        movieController.add(baahubali, City.Bangalore);
        movieController.add(baahubali, City.Delhi);

    }

}
