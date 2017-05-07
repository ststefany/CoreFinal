package DAOpackage;

import Entities.User;
import Exceptions.*;

import java.util.*;
import java.util.stream.*;

public class DAOUsers implements AbstractDAO {
    private static Set<User> allUsers = new HashSet<>();
    private static DAOUsers users = new DAOUsers();

    private DAOUsers() {
    }

    static DAOUsers getInstanse() {
        return users;
    }

    public static void saveUser(String login, String password) throws NonValidDataException {
        if (login == null || password == null)
            throw new NonValidDataException();
        allUsers.add(new User(login, password));
    }

    public static void saveUser(User user) throws NonValidDataException {
        if (user == null)
            throw new NonValidDataException();
        allUsers.add(user);
    }


    public static User removeUser(User user) {
        allUsers.remove(user);
        return user;
    }

    public static User findUserByID(long id) {
        List<User> list = allUsers.stream()
                .filter((User o) -> o.getId() == id)
                .collect(Collectors.toList());
        if (list.size() > 1) {
            throw new DataBaseException();
        }
        return list.get(0);
    }


}
