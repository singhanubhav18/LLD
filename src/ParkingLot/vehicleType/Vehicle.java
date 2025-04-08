package ParkingLot.vehicleType;

public abstract class Vehicle {
    protected String licensePlateNo;
    protected VehicleType vehicleType;

    public Vehicle(String licensePlateNo, VehicleType vehicleType) {
        this.licensePlateNo = licensePlateNo;
        this.vehicleType = vehicleType;
    }
    public VehicleType getType(){
        return vehicleType;
    }
}
