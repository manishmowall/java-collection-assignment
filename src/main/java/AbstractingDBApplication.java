/**
 * Created by mowall on 15/9/16.
 */
public class AbstractingDBApplication {
    public static void main(String[] args) {
        UserList userList;

        MongoDB mongodB = new MongoDB("localhost", 27017, "User", "users");
        userList = new UserList(mongodB);
        userList.displayList();

        FakeDB fakeDB = new FakeDB();
        userList = new UserList(fakeDB);
        userList.displayList();
    }
}
