import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by mowall on 14/9/16.
 */
public class UserList implements GeneralList{
    private List<User> users;

    public UserList(List<User> users) {

        this.users =  users;

    }

    public void displayList() {

        if(users.isEmpty()) {
            System.out.println("DB is empty");
        }
        else {
            for (User user : users) {
                System.out.println(user.getName() + " " + user.getDOB() + " " + user.getEmail());
            }
        }
    }

    public void sort() {
        //using comparable interface to sort user defined class list
        Collections.sort(this.users);
    }


}
