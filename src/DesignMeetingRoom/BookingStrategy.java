package DesignMeetingRoom;

import java.util.List;

public interface BookingStrategy {
    MeetingRoom findAvailableRoom(List<MeetingRoom> rooms);
}

