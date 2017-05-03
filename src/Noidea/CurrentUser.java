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

}
