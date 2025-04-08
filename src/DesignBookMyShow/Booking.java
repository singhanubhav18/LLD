package DesignBookMyShow;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    Show show;
    List<Seat> bookedSeat=new ArrayList<>();
    Payment payment;

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBookedSeat() {
        return bookedSeat;
    }

    public void setBookedSeat(List<Seat> bookedSeat) {
        this.bookedSeat = bookedSeat;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
