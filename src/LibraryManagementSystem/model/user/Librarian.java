package LibraryManagementSystem.model.user;

import LibraryManagementSystem.model.BookItem;
import LibraryManagementSystem.model.catalog.Catalog;


public class Librarian extends User {
    public Librarian(String id, String name, String email) {
        super(id, name, email);
    }

    public void addBook(Catalog catalog, BookItem bookItem) {
        catalog.addBookItem(bookItem);
    }
}
