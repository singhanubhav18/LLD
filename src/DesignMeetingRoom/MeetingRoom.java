package DesignMeetingRoom;

public class MeetingRoom {
    private String id;
    private int capacity;
    private boolean hasProjector;
    private boolean isBooked;

    public MeetingRoom(String id, int capacity, boolean hasProjector) {
        this.id = id;
        this.capacity = capacity;
        this.hasProjector = hasProjector;
        this.isBooked = false;
    }

    public String getId() { return id; }
    public int getCapacity() { return capacity; }
    public boolean hasProjector() { return hasProjector; }
    public boolean isBooked() { return isBooked; }

    public void book() {
        this.isBooked = true;
    }

    public void cancelBooking() {
        this.isBooked = false;
    }
}
