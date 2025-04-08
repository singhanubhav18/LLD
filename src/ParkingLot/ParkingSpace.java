package ParkingLot;

import ParkingLot.vehicleType.Vehicle;

public class ParkingSpace {
    private int id;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSpace(int id) {
        this.id = id;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void vacate() {
        this.vehicle = null;
        this.occupied = false;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
