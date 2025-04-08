package DesignSplitWiseApp.Expense.User;

import DesignSplitWiseApp.Expense.UserExpenseBalanceSheet;

public class User {
    String userId;
    String userName;
    UserExpenseBalanceSheet userExpenseBalanceSheet;


    public User(String userId, String userName, UserExpenseBalanceSheet userExpenseBalanceSheet) {
        this.userId = userId;
        this.userName = userName;
        this.userExpenseBalanceSheet = userExpenseBalanceSheet;
    }

    public String getUserId() {
        return userId;
    }

    public UserExpenseBalanceSheet getUserExpenseBalanceSheet() {
        return userExpenseBalanceSheet;
    }
}
