/**
 * Created by mowall on 15/9/16.
 */
public class AbstractingDBApplication {
    public static void main(String[] args) {
        UserList userList;

        try {
            UserDB userDB = new MongoDB("localhost", 27017, "User", "users");
            userList = new UserList(userDB.selectAllUsers());
            userList.displayList();

            userDB = new TestDB();
            userList = new UserList(userDB.selectAllUsers());
            userList.displayList();
        }
        catch (Exception ex) {

        }
     }
}
