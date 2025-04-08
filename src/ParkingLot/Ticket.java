package ParkingLot;

import ParkingLot.vehicleType.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    private static int ticketCounter = 0;

    private int ticketId;
    private ParkingSpace parkingSpace;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Ticket(ParkingSpace parkingSpace) {
        this.ticketId = ++ticketCounter;
        this.parkingSpace = parkingSpace;
        this.entryTime = LocalDateTime.now();
    }

    public void setExitTime() {
        this.exitTime = LocalDateTime.now();
    }

    public long getDurationInMinutes() {
        if (exitTime != null) {
            return java.time.Duration.between(entryTime, exitTime).toMinutes();
        }
        return 0;
    }

    public int getTicketId() {
        return ticketId;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }
}

