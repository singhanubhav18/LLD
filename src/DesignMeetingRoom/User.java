package DesignMeetingRoom;

public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void notifyAvailability(MeetingRoom room) {
        System.out.println("Hey " + name + ", Room available: " + room.getId());
    }
}
