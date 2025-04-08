package DesignSplitWiseApp.Expense.split;

import java.util.*;

public interface ExpenseSplit {

    public  void validateSplitRequest(List<Split> splitList, double amount);
}
