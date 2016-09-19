package org.nitishm.javacollectionassignment;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        UserList userList;

        try {
            UserDB userDB = new MongoDB("localhost", 27017, "User", "users");
            userList = new UserList(userDB.selectAllUsers());

            System.out.println("==============Before Sorting===============");
            userList.displayList();

            System.out.println("==============After Sorting===============");
            userList.sort();
            userList.displayList();

            System.out.println("==============Equals Demo===============");
            List<User> users = userList.getUserList();
            User user1 = users.get(0);
            User user2 = users.get(2);

            System.out.println("is " +user1.getName() +" equals to " + user2.getName() +"?");
            if(user1.equals(user2))
                System.out.println("Yes");
            else
                System.out.println("No");

            System.out.println("================Comparator Demo==================");
            Collections.sort(users, new DateOfBirthComparator());
            userList.displayList();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
