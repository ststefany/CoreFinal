package DAOpackage;

import Entities.*;
import Exceptions.NonValidDataException;
import Exceptions.WrongUserException;

public class DAO <T> implements AbstractDAO <T> {
    private static DAO database = new DAO();
    static private DAOHotels hotels = new DAOHotels();
    static private AbstractDAO users = new DAOUsers();

    private DAO() {}


    public static AbstractDAO getData() {
        return database;
    }


    public static void bookRoom (long roomId, long userId, long hotelId) {
        Room room = null;
        try {
            User user = DAOUsers.findUserByID(userId);
            if (!user.isCurrent()) throw new WrongUserException();
            room = DAOHotels.findHotelbyID(hotelId).findRoom(roomId);
            if (room.isFree()) room.setUserReserved(user);
            else System.err.println("This room is already reserved");
        } catch (WrongUserException e) {
            System.err.println("Change current user");
        }
        catch (NonValidDataException e) {
            System.err.println("Wrong user ID");
        }
        catch (NullPointerException e) {
            System.err.println("Wrong room ID");
        }
    }

}
