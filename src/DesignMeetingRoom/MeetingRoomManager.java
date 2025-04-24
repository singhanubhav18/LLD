package DesignMeetingRoom;

import java.util.ArrayList;
import java.util.List;

public class MeetingRoomManager {
    private static MeetingRoomManager instance;
    private List<MeetingRoom> rooms;
    private List<Observer> observers;

    private MeetingRoomManager() {
        rooms = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static MeetingRoomManager getInstance() {
        if (instance == null) {
            instance = new MeetingRoomManager();
        }
        return instance;
    }

    public void addRoom(MeetingRoom room) {
        rooms.add(room);
    }

    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(MeetingRoom room) {
        for (Observer observer : observers) {
            observer.notifyAvailability(room);
        }
    }

    public boolean bookRoom(BookingStrategy strategy) {
        MeetingRoom availableRoom = strategy.findAvailableRoom(rooms);
        if (availableRoom != null) {
            availableRoom.book();
            System.out.println("Room booked: " + availableRoom.getId());
            notifyObservers(availableRoom);
            return true;
        } else {
            System.out.println("All meeting rooms are currently booked. Please try again later.");
            return false;
        }
    }
}
