package Entities;


public class CurrentUser extends User {
    private static User currentUser = null;

    private CurrentUser(String login, String password) {
        super(login, password);
    }

    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser () {
        return currentUser;
    }


}
