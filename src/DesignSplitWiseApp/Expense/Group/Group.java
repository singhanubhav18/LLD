package DesignSplitWiseApp.Expense.Group;

import DesignSplitWiseApp.Expense.Expense;
import DesignSplitWiseApp.Expense.ExpenseController;
import DesignSplitWiseApp.Expense.User.User;

import java.util.List;

public class Group {
    String groupId;
    String groupName;
    List<User> groupMember;
    List<Expense> expenseList;
    ExpenseController expenseController;

    public Group(List<User> groupMember, List<Expense> expenseList, ExpenseController expenseController) {
        this.groupMember = groupMember;
        this.expenseList = expenseList;
        this.expenseController = expenseController;
    }

    public void addMember(User member){groupMember.add(member);}

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
