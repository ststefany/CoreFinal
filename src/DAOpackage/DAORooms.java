package DAOpackage;

import Entities.*;
import java.util.*;

public class DAORooms implements AbstractDAO {

    private static AbstractDAO rooms = new DAORooms();
    private static Map<Hotel, Room> allRooms = new HashMap<>();


    private DAORooms() {
    }

    AbstractDAO getData() {
        return rooms;
    }

}
