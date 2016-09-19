package org.nitishm.javacollectionassignment;

import java.util.List;

public interface UserDB {
    List<User> selectAllUsers() throws Exception;
}
