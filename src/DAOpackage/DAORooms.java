package DAOpackage;

import Entities.*;
import Exceptions.NonValidDataException;

import java.util.*;

public class DAORooms implements AbstractDAO {

    private static Map<Room, Hotel> allRooms = new HashMap<>();

    public static void save (Room room) {
        if (room != null)
        allRooms.put(room, room.getHotel());
    }

    public Map<Room, Hotel> getAllRooms() {
        return allRooms;
    }
}
