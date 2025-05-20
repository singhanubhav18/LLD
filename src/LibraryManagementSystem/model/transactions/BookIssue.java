package LibraryManagementSystem.model.transactions;

import LibraryManagementSystem.model.BookItem;
import LibraryManagementSystem.model.user.Member;

import java.util.Date;

// BookIssue.java
public class BookIssue {
    private Member member;
    private BookItem bookItem;
    private Date issueDate;
    private Date dueDate;

    public BookIssue(Member member, BookItem bookItem, Date issueDate, Date dueDate) {
        this.member = member;
        this.bookItem = bookItem;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public double returnBook(Date returnDate, FineStrategy strategy) {
        return strategy.calculateFine(dueDate, returnDate);
    }
}

