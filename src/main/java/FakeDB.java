import java.util.ArrayList;
import java.util.List;

/**
 * Created by mowall on 14/9/16.
 */
public class FakeDB implements UserDB {
    List<User> users = new ArrayList<User>();
    User user;

    public FakeDB() {
        user = new User("FakeName","FakeDOB","FakeEmall");
        users.add(user);
    }

    public void getConnection() {}

    public List<User> selectAll() {
        return users;
    }

    public void closeConnection() {}

}
