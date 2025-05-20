package LibraryManagementSystem.model.transactions;

import java.util.Date;

// FineStrategy.java
public interface FineStrategy {
    double calculateFine(Date dueDate, Date returnDate);
}

