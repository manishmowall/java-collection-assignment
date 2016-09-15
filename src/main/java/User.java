/**
 * Created by mowall on 14/9/16.
 */
public class User {
    private String name;
    private String DOB;
    private String email;


    public User(String name, String DOB, String email) {
        this.name = name;
        this.DOB = DOB;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public String getDOB() {
        return DOB;
    }

    public String getEmail() {
        return email;
    }

}
