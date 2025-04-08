package DesignSplitWiseApp.Expense;

import DesignSplitWiseApp.Expense.split.Split;
import DesignSplitWiseApp.ExpenseSplitType;
import DesignSplitWiseApp.Expense.User.User;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    String expenseId;
    String description;
    double amount;
    User paidByUser;

    ExpenseSplitType splitType;
    List<Split> splitList=new ArrayList<>();

    public Expense(String expenseId, String description, double amount, User paidByUser, ExpenseSplitType splitType, List<Split> splitList) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.paidByUser = paidByUser;
        this.splitType = splitType;
        this.splitList = splitList;
    }
}
