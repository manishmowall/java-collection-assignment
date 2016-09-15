import java.util.Collections;
import java.util.List;

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

            System.out.println("==============Equals Demo===============");

            List<User> users = userList.getUserList();
            User user1 = users.get(0);
            User user2 = users.get(1);

            System.out.println(user1.equals(user2));

            System.out.println("================Comparator Demo==================");

            Collections.sort(users, new DateOfBirthComparator());
            userList.displayList();


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
