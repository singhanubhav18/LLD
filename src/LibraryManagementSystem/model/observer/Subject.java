package LibraryManagementSystem.model.observer;

// Subject.java
public interface Subject {
    void registerObserver(Observer obs);
    void notifyObservers(String msg);
}

