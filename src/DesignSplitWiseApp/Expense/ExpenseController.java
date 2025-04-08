package DesignSplitWiseApp.Expense;

import DesignSplitWiseApp.Expense.split.ExpenseSplit;
import DesignSplitWiseApp.Expense.split.Split;
import DesignSplitWiseApp.ExpenseSplitType;
import DesignSplitWiseApp.Expense.User.User;
import DesignSplitWiseApp.SplitFactory;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController(BalanceSheetController balanceSheetController) {
        this.balanceSheetController = balanceSheetController;
    }

    public Expense createExpense(String expenseId,
                                 String description,
                                 double amount, List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser){

        ExpenseSplit expenseSplit= SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitDetails,amount);
        Expense expense=new Expense(expenseId,description,amount,paidByUser,splitType,splitDetails);
        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser,splitDetails,amount);
        return expense;

    }
}
