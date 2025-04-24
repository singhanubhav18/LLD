package DesignMeetingRoom;

public class MeetingRoomBuilder {
    private String id;
    private int capacity;
    private boolean hasProjector;

    public MeetingRoomBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public MeetingRoomBuilder setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public MeetingRoomBuilder setProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
        return this;
    }

    public MeetingRoom build() {
        return new MeetingRoom(id, capacity, hasProjector);
    }
}

