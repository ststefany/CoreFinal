package DAOpackage;

import Entities.Room;
import Exceptions.DataBaseException;
import Exceptions.NonValidDataException;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DAORooms implements AbstractDAO {

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
            for (String param : params.keySet()) {
                try {
                    Field field = DAORooms.findFieldWithName(param);
                    if (field.get(room).equals(params.get(param)))
                        fits = true;
                    else break;
                } catch (NonValidDataException e) {
                    System.err.println("Entered parameters are not valid. Try with different parameneters");
                } catch (IllegalAccessException e) {
                    System.err.println("Problem with access to the data");
                }
            }
            if (fits) result.add(room);
            fits = false;
        }
        return result;
    }

    static private Field findFieldWithName(String name) throws NonValidDataException, DataBaseException {
        if (name == null) throw new NonValidDataException();
        for (Field field : Room.class.getDeclaredFields()) {
            if (name.equals(field.getName()))
                return field;
        }
        throw new DataBaseException();
    }

    public Set<Room> getAllRooms() {
        return allRooms;
    }
}
