package Noidea;


import Entities.User;

public class CurrentUser extends User {
    static long id;
    static String login;
    static String password;

    public void setCurrentUser(User user) {
    }

    public CurrentUser(String login, String password) {
        super(login, password);
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

    }
}
