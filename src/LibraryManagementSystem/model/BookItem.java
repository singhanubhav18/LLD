package LibraryManagementSystem.model;

public class BookItem {
    private String barcode;
    private BookStatus status;
    private Book book;

    public BookItem(String barcode, Book book) {
        this.barcode = barcode;
        this.status = status;
        this.book = book;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
