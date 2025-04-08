package ParkingLot;

import ParkingLot.vehicleType.*;

public class ParkingLotMain {
    public static void main(String[] args) {

        // Initialize Parking System with 10 parking spaces and $0.05 per minute
        ParkingSystem system = new ParkingSystem(10, 0.05);

        // Create vehicles
        Vehicle vehicle1 = new Car("ABC123");
        Vehicle vehicle2 = new MotorCycle("XYZ456");

        // Park vehicles
        Ticket ticket1 = system.parkVehicle(vehicle1);
        System.out.println("Vehicle1 parked. Ticket ID: " + ticket1.getTicketId());

        Ticket ticket2 = system.parkVehicle(vehicle2);
        System.out.println("Vehicle2 parked. Ticket ID: " + ticket2.getTicketId());


        // Print available parking spaces
        System.out.println("Available Spaces: " + system.getAvailableSpaces());
    }
}

