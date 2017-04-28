package DAOpackage;

import Entities.User;
import Exceptions.*;
import java.util.*;
import java.util.stream.*;

public class DAOUsers implements AbstractDAO {
    static private AbstractDAO users = new DAOUsers();
    static private Set<User> allUsers = new HashSet<>();

    private DAOUsers() {}

    public static AbstractDAO getData() {
        return users;
    }

    public static void saveUser(String login, String password) throws NonValidDataException {
        if (login == null || password == null)
            throw new NonValidDataException();
        allUsers.add(new User(login, password));
    }

    public static User removeUser (User user) {
        allUsers.remove(user);
        return user;
    }

    public static User findUserByID(long id) throws NonValidDataException {
        List<User> list = allUsers.stream()
                .filter((User o) -> o.getId() == id)
                .collect(Collectors.toList());
        if (list.size()> 1) {
            throw new DataBaseException();}
        if (list.size() == 0) throw new NonValidDataException();
        return list.get(0);
    }



}
