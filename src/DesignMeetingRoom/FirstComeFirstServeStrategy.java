package DesignMeetingRoom;

import java.util.List;

public class FirstComeFirstServeStrategy implements BookingStrategy {

    @Override
    public MeetingRoom findAvailableRoom(List<MeetingRoom> rooms) {
        for (MeetingRoom room : rooms) {
            if (!room.isBooked()) {
                return room;
            }
        }
        return null;
    }
}

