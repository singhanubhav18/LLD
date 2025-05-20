package LibraryManagementSystem.model.catalog;

import LibraryManagementSystem.model.BookItem;
import LibraryManagementSystem.model.observer.Observer;
import LibraryManagementSystem.model.observer.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Catalog.java
public class Catalog implements Search, Subject {
    private static Catalog instance;
    private Map<String, List<BookItem>> booksByTitle = new HashMap<>();
    private List<Observer> observers = new ArrayList<>();

    private Catalog() {}

    public static Catalog getInstance() {
        if (instance == null) instance = new Catalog();
        return instance;
    }

    public void addBookItem(BookItem bookItem) {
        booksByTitle
                .computeIfAbsent(bookItem.getBook().getTitle(), k -> new ArrayList<>())
                .add(bookItem);
        notifyObservers("New book added: " + bookItem.getBook().getTitle());
    }

    public List<BookItem> searchByTitle(String title) {
        return booksByTitle.getOrDefault(title, new ArrayList<>());
    }

    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void notifyObservers(String msg) {
        for (Observer obs : observers) {
            obs.update(msg);
        }
    }
}

