package org.nitishm.javacollectionassignment;

import java.util.Comparator;

public class DateOfBirthComparator implements Comparator {
    public int compare(Object o1, Object o2){
        User user1 = (User) o1;
        User user2 = (User) o2;
        return user1.getEmail().compareTo(user2.getEmail());
    }
}
