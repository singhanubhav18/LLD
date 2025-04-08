package DesignSplitWiseApp;

import DesignSplitWiseApp.Expense.split.EqualExpenseSplit;
import DesignSplitWiseApp.Expense.split.ExpenseSplit;
import DesignSplitWiseApp.Expense.split.PercentageExpenseSplit;
import DesignSplitWiseApp.Expense.split.UnEqualExpenseSplit;

public class SplitFactory {

    public  static ExpenseSplit getSplitObject(ExpenseSplitType splitType){
        switch (splitType){
            case EQUAL -> {
                return new EqualExpenseSplit();
            }
            case UNEQUAL -> {
                return new UnEqualExpenseSplit();
            }
            case PERCENTAGE -> {
                return new PercentageExpenseSplit();
            }
            default -> {
                return null;
            }
        }
    }
}
