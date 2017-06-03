package DAOpackage;

import Entities.Room;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DAORooms {

    private static Set<Room> allRooms = new HashSet<>();
    private static DAORooms rooms = new DAORooms();

    private DAORooms() {
    }

    static DAORooms getInstance() {
        return rooms;
    }

    public static void save(Room room) {
        if (room != null)
            allRooms.add(room);
    }

    public static Set<Room> findRoomByParams(Map<String, String> params) {
        Set<Room> result = new HashSet<>();
        boolean fits = false;

        for (Room room : allRooms) {
            if (room.doesFit(params)){
            result.add(room);}
        }
        return result;
    }


    public Set<Room> getAllRooms() {
        return allRooms;
    }
}
