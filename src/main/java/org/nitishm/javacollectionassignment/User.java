package org.nitishm.javacollectionassignment;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class User implements Comparable<User> {
    private String name;
    private String dateOfBirth;
    private String email;

    public User(String name, String dateOfBirth, String email) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getdateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    //used for sorting list of users
    public int compareTo(User user2) {
        return getName().compareTo(user2.getName());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(getName(),user.getName());
        if (!getName().equals(user.getName())) return false;
        if (!getdateOfBirth().equals(user.getdateOfBirth())) return false;
        return getEmail().equals(user.getEmail());

    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getName());
        builder.append(getdateOfBirth());
        builder.append(getEmail());
        return builder.toHashCode();
    }
}

