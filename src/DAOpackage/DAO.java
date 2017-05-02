package DAOpackage;

import Entities.*;
import Exceptions.NonValidDataException;
import Exceptions.WrongUserException;

public class DAO <T> implements AbstractDAO <T> {
    private static DAO database = new DAO();
    static private DAOHotels hotels;
    static private DAOUsers users;

    private DAO() {
    }


    public static AbstractDAO getData() {
        return database;
    }


    public static Room findRoom (long roomId, long userId, long hotelId) {
        Room room = null;
        try {
            User user = DAOUsers.findUserByID(userId);
            if (!user.isCurrent()) throw new WrongUserException();
            else
                room = DAOHotels.findHotelbyID(hotelId).findRoom(roomId);
        } catch (WrongUserException e) {
            System.err.println("Change current user");
        }
        catch (NonValidDataException e) {
            System.err.println("Wrong user ID");
        }
        return room;
    }
}
