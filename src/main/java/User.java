/**
 * Created by mowall on 14/9/16.
 */
public class User implements Comparable<User> {
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

    //used for sorting list of users
    public int compareTo(User user2) {
        return name.compareTo(user2.getName());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        if (!DOB.equals(user.DOB)) return false;
        return email.equals(user.email);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + DOB.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }
}
