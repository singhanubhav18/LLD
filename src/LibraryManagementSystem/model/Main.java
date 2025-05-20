package LibraryManagementSystem.model;


import LibraryManagementSystem.model.catalog.Catalog;
import LibraryManagementSystem.model.observer.Observer;
import LibraryManagementSystem.model.transactions.BookIssue;
import LibraryManagementSystem.model.transactions.FineStrategy;
import LibraryManagementSystem.model.transactions.SimpleFineStrategy;
import LibraryManagementSystem.model.user.Librarian;
import LibraryManagementSystem.model.user.Member;
import LibraryManagementSystem.model.user.User;
import LibraryManagementSystem.model.user.UserFactory;
import java.util.Arrays;
import java.util.List;

// Main.java
public class Main {
    public static void main(String[] args) {
        Catalog catalog = Catalog.getInstance();

        User librarian = UserFactory.createUser(UserType.LIBRARIAN, "lib01", "Alice", "alice@lib.com");
        User member = UserFactory.createUser(UserType.MEMBER, "mem01", "Bob", "bob@mem.com");

        catalog.registerObserver((Observer) member);

        Book book = new Book("123", "Effective Java", Arrays.asList("Joshua Bloch"), BookType.REFERENCE);
        BookItem item = new BookItem("BAR001", book);

        ((Librarian) librarian).addBook(catalog, item);



        String searchTitle = "Effective Javas";
        List<BookItem> found = catalog.searchByTitle(searchTitle);

        if (!found.isEmpty()) {
            BookItem toBorrow = found.get(0);
            boolean borrowed = ((Member) member).borrow(toBorrow);
            System.out.println(borrowed
                    ? "Book borrowed: " + toBorrow.getBook().getTitle()
                    : "Book unavailable: " + toBorrow.getBook().getTitle());
        } else {
            System.out.println("Book not found: " + searchTitle);
        }
    }
}

