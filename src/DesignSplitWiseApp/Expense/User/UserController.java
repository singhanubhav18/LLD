package DesignSplitWiseApp.Expense.User;

import java.util.*;

public class UserController {
    List<User> userList;

    public UserController(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user){
        userList.add(user);
    }

    public User getUser(String userId){
        for(User user:userList){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        return null;
    }
}
