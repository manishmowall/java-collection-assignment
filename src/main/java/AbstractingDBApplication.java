/**
 * Created by mowall on 15/9/16.
 */
public class AbstractingDBApplication {
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
            System.out.println();
            System.out.println("========================================");
            userDB = new TestDB();
            userList = new UserList(userDB.selectAllUsers());
            userList.displayList();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
     }
}
