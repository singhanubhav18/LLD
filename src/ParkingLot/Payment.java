package ParkingLot;

public class Payment {
    private double ratePerMinute;

    public Payment(double ratePerMinute) {
        this.ratePerMinute = ratePerMinute;
    }

    public double calculateFee(Ticket ticket) {
        long duration = ticket.getDurationInMinutes();
        return duration * ratePerMinute;
    }
}

