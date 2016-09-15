/**
 * Created by mowall on 15/9/16.
 */
public class AbstractingDBApplication {
    public static void main(String[] args) {
        UserList userList;

        UserDB userDB = new MongoDB("localhost", 27017, "User", "users");
        userList = new UserList(userDB.selectAll());
        userList.displayList();

        userDB = new FakeDB();
        userList = new UserList(userDB.selectAll());
        userList.displayList();
    }
}
