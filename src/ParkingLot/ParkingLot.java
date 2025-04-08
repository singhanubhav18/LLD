
package ParkingLot;
import ParkingLot.vehicleType.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    final List<ParkingSpace> parkingSpaces;
    private int availableSpaces;

    public ParkingLot(int totalSpaces) {
        this.parkingSpaces = new ArrayList<>(totalSpaces);
        this.availableSpaces = totalSpaces;
        initializeParkingSpaces(totalSpaces);
    }

    private void initializeParkingSpaces(int totalSpaces) {
        for (int i = 1; i <= totalSpaces; i++) {
            parkingSpaces.add(new ParkingSpace(i));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpace availableSpace = findAvailableSpace();
        if (availableSpace != null) {
            availableSpace.park(vehicle);
            availableSpaces--;
            return true;
        }
        return false;
    }

    public boolean exitVehicle(int spaceId) {
        ParkingSpace space = getParkingSpaceById(spaceId);
        if (space != null && space.isOccupied()) {
            space.vacate();
            availableSpaces++;
            return true;
        }
        return false;
    }

    private ParkingSpace findAvailableSpace() {
        for (ParkingSpace space : parkingSpaces) {
            if (!space.isOccupied()) {
                return space;
            }
        }
        return null; // No available space
    }

    private ParkingSpace getParkingSpaceById(int spaceId) {
        for (ParkingSpace space : parkingSpaces) {
            if (space.getId() == spaceId) {
                return space;
            }
        }
        return null;
    }

    public int getAvailableSpaces() {
        return availableSpaces;
    }
}
