package ParkingLot;

import ParkingLot.vehicleType.Vehicle;

public class ParkingSystem {
    private ParkingLot parkingLot;
    private Payment paymentSystem;
    private Ticket currentTicket;

    public ParkingSystem(int totalSpaces, double ratePerMinute) {
        this.parkingLot = new ParkingLot(totalSpaces);
        this.paymentSystem = new Payment(ratePerMinute);
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        if (parkingLot.parkVehicle(vehicle)) {
            ParkingSpace space = findParkingSpaceForVehicle(vehicle);
            currentTicket = new Ticket(space);
            return currentTicket;
        }
        return null; // Parking lot is full
    }

    public boolean exitVehicle() {
        if (currentTicket != null) {
            currentTicket.setExitTime();
            double fee = paymentSystem.calculateFee(currentTicket);
            System.out.println("Parking Fee for Ticket ID " + currentTicket.getTicketId() + ": rupees" + fee);
            return parkingLot.exitVehicle(currentTicket.getParkingSpace().getId());
        }
        return false; // No ticket or invalid exit
    }

    private ParkingSpace findParkingSpaceForVehicle(Vehicle vehicle) {
        for (ParkingSpace space : parkingLot.parkingSpaces) {
            if (!space.isOccupied()) {
                return space;
            }
        }
        return null;
    }

    public int getAvailableSpaces() {
        return parkingLot.getAvailableSpaces();
    }
}

