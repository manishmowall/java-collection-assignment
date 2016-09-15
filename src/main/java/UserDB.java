import java.util.List;

/**
 * Created by mowall on 14/9/16.
 */
public interface UserDB {
    void getConnection();
    List<User> selectAll();
}
