import java.util.ArrayList;
import java.util.List;

/**
 * Created by mowall on 14/9/16.
 */
public class TestDB implements UserDB {
    List<User> users = new ArrayList<User>();
    User user;

    public TestDB() {
        user = new User("TestName","TestDOB","TestEmall");
        users.add(user);
    }

    public List<User> selectAllUsers() {
        return users;
    }

}
