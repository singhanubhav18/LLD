package DesignMeetingRoom;

public class Main {
    public static void main(String[] args) {
        MeetingRoomManager manager = MeetingRoomManager.getInstance();

        // Create first meeting room
        MeetingRoom room1 = new MeetingRoomBuilder()
                .setId("MR101")
                .setCapacity(10)
                .setProjector(true)
                .build();

        // Create second meeting room
        MeetingRoom room2 = new MeetingRoomBuilder()
                .setId("MR102")
                .setCapacity(6)
                .setProjector(false)
                .build();

        // Add both rooms
        manager.addRoom(room1);
        manager.addRoom(room2);

        // Attach observers
        manager.attachObserver(new User("Alice"));
        manager.attachObserver(new User("Bob"));

        BookingStrategy strategy = new FirstComeFirstServeStrategy();

        // First booking attempt (should book MR101)
        manager.bookRoom(strategy);

        // Second booking attempt (should book MR102)
        manager.bookRoom(strategy);

        // Third booking attempt (no rooms left)
        manager.bookRoom(strategy);
    }
}
