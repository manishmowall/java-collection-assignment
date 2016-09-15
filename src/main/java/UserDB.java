import java.util.List;

/**
 * Created by mowall on 14/9/16.
 */
public interface UserDB {
    List<User> selectAllUsers() throws Exception;
}
