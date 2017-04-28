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

    public boolean isCurrent() {
        return true;
    }
}
