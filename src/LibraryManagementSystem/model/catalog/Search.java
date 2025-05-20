package LibraryManagementSystem.model.catalog;

import LibraryManagementSystem.model.BookItem;

import java.util.List;

// Search.java
public interface Search {
    List<BookItem> searchByTitle(String title);
}

