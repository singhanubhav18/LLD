package DesignSplitWiseApp.Expense;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    Map<String,Balance> userWiseBalance;
    double totalExpense;
    double totalPayment;
    double totalOwe;
    double totalGetBack;

    public UserExpenseBalanceSheet(){
        userWiseBalance=new HashMap<>();
        totalExpense=0;
        totalOwe=0;
        totalGetBack=0;
    }


    public Map<String, Balance> getUserWiseBalance() {
        return userWiseBalance;
    }

    public void setUserWiseBalance(Map<String, Balance> userWiseBalance) {
        this.userWiseBalance = userWiseBalance;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public double getTotalOwe() {
        return totalOwe;
    }

    public void setTotalOwe(double totalOwe) {
        this.totalOwe = totalOwe;
    }

    public double getTotalGetBack() {
        return totalGetBack;
    }

    public void setTotalGetBack(double totalGetBack) {
        this.totalGetBack = totalGetBack;
    }
}
