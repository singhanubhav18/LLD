package LibraryManagementSystem.model;

import java.util.List;

public class Book {
    private String isbn;
    private String title;
    private List<String> authors;
    private BookType type;

    public Book(String isbn, String title, List<String> authors, BookType type) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.type = type;
    }


    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public BookType getType() {
        return type;
    }
}
