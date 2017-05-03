package Entities;

public class User {
    long id;
    String login;
    String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.id = Math.round(Math.random())*10001;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    public boolean isCurrent() {
        return true;

    }
}
