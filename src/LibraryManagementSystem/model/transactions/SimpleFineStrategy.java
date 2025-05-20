package LibraryManagementSystem.model.transactions;

import java.util.Date;

public class SimpleFineStrategy implements FineStrategy {
    @Override
    public double calculateFine(Date dueDate, Date returnDate) {
        long diff = returnDate.getTime() - dueDate.getTime();
        long daysLate = diff / (1000 * 60 * 60 * 24);
        return daysLate > 0 ? daysLate * 2.0 : 0.0;
    }
}
