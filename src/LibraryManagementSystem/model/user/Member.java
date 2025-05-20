package LibraryManagementSystem.model.user;

import LibraryManagementSystem.model.BookItem;
import LibraryManagementSystem.model.BookStatus;
import LibraryManagementSystem.model.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Member extends User implements Observer {
    private List<BookItem> borrowedBooks = new ArrayList<>();

    public Member(String id, String name, String email) {
        super(id, name, email);
    }

    public boolean borrow(BookItem bookItem) {
        if (bookItem.getStatus() == BookStatus.AVAILABLE) {
            borrowedBooks.add(bookItem);
            bookItem.setStatus(BookStatus.LOANED);
            return true;
        }
        return false;
    }

    public boolean returnBook(BookItem bookItem) {
        if (borrowedBooks.contains(bookItem)) {
            borrowedBooks.remove(bookItem);
            bookItem.setStatus(BookStatus.AVAILABLE);
            return true;
        }
        return false;
    }

    @Override
    public void update(String msg) {
        System.out.println("Notification for " + name + ": " + msg);
    }
}

